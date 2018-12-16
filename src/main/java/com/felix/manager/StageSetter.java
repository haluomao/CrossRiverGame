package com.felix.manager;

import java.util.ArrayList;
import java.util.List;

import com.felix.builder.Region;
import com.felix.builder.Region.Position;
import com.felix.singleton.SingletonStage;
import com.felix.builder.Tiger;
import com.felix.observer.IObserver;
import com.felix.observer.ISubject;

/**
 * The stage setter.
 *
 * @author Felix
 */
public class StageSetter implements ISubject {

    private SingletonStage stage;
    private List<IObserver> observers = new ArrayList<>();

    public StageSetter(SingletonStage stage) {
        this.stage = stage;
    }

    public void countTime() {
        stage.setBeginTime(System.currentTimeMillis());
    }

    public void clearBoat() {
        stage.getBoat().clear();
    }

    public boolean checkReady(List<String> names) {
        boolean canSail = false;
        for (String name : names) {
            if (!stage.getTigerMap().containsKey(name)) {
                canSail = false;
                break;
            }
            Tiger tiger = stage.getTigerMap().get(name);
            if (tiger.isCanSail()) {
                canSail = true;
            }
            if ((stage.getBoat().getPosition() == Position.NORTH
                    && stage.getSouth().getTigerList().contains(tiger))
                    || (stage.getBoat().getPosition() == Position.SOUTH
                    && stage.getNorth().getTigerList().contains(tiger))) {
                canSail = false;
                break;
            }
        }
        if (!canSail) {
            notifyNotReady();
        }
        return canSail;
    }

    public void sail(List<String> tigers) {
        if (stage.getBoat().getPosition() != Position.NORTH) {
            for (String name : tigers) {
                stage.getNorth().come(stage.getTigerMap().get(name));
                stage.getSouth().leave(stage.getTigerMap().get(name));
                stage.getBoat().come(stage.getTigerMap().get(name));
            }
            stage.getBoat().setPosition(Position.NORTH);
        } else {
            for (String name : tigers) {
                stage.getSouth().come(stage.getTigerMap().get(name));
                stage.getNorth().leave(stage.getTigerMap().get(name));
                stage.getBoat().come(stage.getTigerMap().get(name));
            }
            stage.getBoat().setPosition(Position.SOUTH);
        }
    }

    public boolean checkDone() {
        boolean done = stage.getSouth().getTigerList().size() == 0;
        if (done) {
            notifyDone();
        }
        return done;
    }

    public boolean checkSafe() {
        for (Region region : stage.getRegions()) {
            for (Tiger tiger : region.getTigerList()) {
                if (tiger.canAttack()) {
                    for (Tiger inDangerTiger : region.getTigerList()) {
                        if (inDangerTiger.getSize() == Tiger.SIZE.SMALL &&
                                !region.getTigerList().contains(inDangerTiger.getParent())) {
                            notifyAccident(inDangerTiger, region);
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    @Override
    public void registerObserver(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyAccident(Tiger tiger, Region region) {
        for (IObserver observer : observers) {
            observer.handleAccident(tiger, region);
        }
    }

    @Override
    public void notifyNotReady() {
        for (IObserver observer : observers) {
            observer.handleNotReady();
        }
    }

    @Override
    public void notifyDone() {
        for (IObserver observer : observers) {
            observer.handleDone();
        }
    }

    @Override
    public void notifyNotSafe() {
        for (IObserver observer : observers) {
            observer.handleNotSafe();
        }
    }
}
