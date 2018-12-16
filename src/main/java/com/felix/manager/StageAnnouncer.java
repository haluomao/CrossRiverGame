package com.felix.manager;

import com.felix.builder.IRegion;
import com.felix.builder.Region.Position;
import com.felix.singleton.SingletonStage;
import com.felix.builder.Tiger;
import com.felix.observer.AbstractObserver;

/**
 * The stage announcer.
 *
 * @author Felix
 */
public class StageAnnouncer extends AbstractObserver {
    private SingletonStage stage;

    public StageAnnouncer(SingletonStage stage) {
        this.stage = stage;
    }

    public void handleNotReady() {
        printCannotSail();
    }

    public void handleNotSafe() {
        printGameOver();
    }

    public void handleDone() {
        printWinMessage();
    }

    @Override
    public void handleAccident(Tiger inDangerTiger, IRegion region) {
        System.out.println("Accident: Tiger \"" + inDangerTiger.getName() + "\" died on "
                + region.getName() + ".");
        printGameOver();
    }

    public void printWinMessage() {
        System.out.println("/////////////////////////////////////////");
        System.out.println("----------------Well done!---------------");
        System.out.println("Time(s):" + (System.currentTimeMillis() - stage.getBeginTime()) / 1000);
        System.out.println("-----------------------------------------");
        System.out.println("/////////////////////////////////////////");
        System.out.println();
    }

    private void printGameOver() {
        System.out.println("Game Over!");
    }

    private void printCannotSail() {
        System.out.println("No tiger can sail!");
    }

    private void printPrompt() {
        System.out.println("Tiger sailors: A B C b");
    }

    public void printStage() {
        printPrompt();
        // print north bank
        System.out.println("------------------------------");
        System.out.print("NORTH: ");
        for (Tiger tiger : stage.getNorth().getTigerList()) {
            System.out.print(tiger.getName());
            System.out.print(" ");
        }
        System.out.println();

        // print boat and river
        if (stage.getBoat().getPosition() == Position.NORTH) {
            System.out.println("~~~~~~~~~~~~\\____/~~~~~~~~~~~~");
        } else {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        if (stage.getBoat().getPosition() == Position.SOUTH) {
            System.out.println("~~~~~~~~~~~~\\____/~~~~~~~~~~~~");
        } else {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }

        // print south bank
        System.out.print("SOUTH: ");
        for (Tiger tiger : stage.getSouth().getTigerList()) {
            System.out.print(tiger.getName());
            System.out.print(" ");
        }
        System.out.println("\n------------------------------");
    }

}
