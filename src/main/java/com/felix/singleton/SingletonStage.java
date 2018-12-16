package com.felix.singleton;

import java.util.List;
import java.util.Map;

import com.felix.builder.Boat;
import com.felix.builder.Region;
import com.felix.builder.Tiger;
import com.felix.factory.StageFactory;
import com.felix.memento.Memento;
import com.google.common.collect.Lists;

/**
 * The singletion stage.
 *
 * @author Felix
 */
public class SingletonStage {

    private Region north;
    private Region south;
    private Boat boat;
    private Map<String, Tiger> tigerMap;
    private List<Region> regions;
    private long beginTime;

    private static volatile SingletonStage stage;

    private SingletonStage() {
    }

    public static SingletonStage getInstance() {
        if (stage == null) {
            synchronized (StageFactory.class) {
                if (stage == null) {
                    stage = new SingletonStage();
                }
            }
        }
        return stage;
    }

    public void restoreMemento(Memento memento) {
        this.boat = memento.getBoat();
        this.south = memento.getSouth();
        this.north = memento.getNorth();
        this.boat.setPosition(Region.Position.SOUTH);
        this.boat.clear();
        this.north.clear();
        this.south.setTigerList(Lists.newArrayList(tigerMap.values()));
        this.beginTime = System.currentTimeMillis();
    }

    public Region getNorth() {
        return north;
    }

    public void setNorth(Region north) {
        this.north = north;
    }

    public Region getSouth() {
        return south;
    }

    public void setSouth(Region south) {
        this.south = south;
    }

    public Boat getBoat() {
        return boat;
    }

    public void setBoat(Boat boat) {
        this.boat = boat;
    }

    public Map<String, Tiger> getTigerMap() {
        return tigerMap;
    }

    public void setTigerMap(Map<String, Tiger> tigerMap) {
        this.tigerMap = tigerMap;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }

    public long getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(long beginTime) {
        this.beginTime = beginTime;
    }
}
