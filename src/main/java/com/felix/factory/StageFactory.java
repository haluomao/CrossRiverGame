package com.felix.factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.felix.command.CommandImpl;
import com.felix.command.ICommand;
import com.felix.builder.Boat;
import com.felix.builder.Region;
import com.felix.singleton.SingletonStage;
import com.felix.builder.Tiger;
import com.felix.manager.StageAnnouncer;
import com.felix.manager.StageCleaner;
import com.felix.manager.StageSetter;
import com.felix.memento.Memento;
import com.felix.memento.Storage;
import com.google.common.collect.Lists;

/**
 * Stage Factory.
 *
 * @author Felix
 */
public class StageFactory {

    private static volatile StageFactory factory;
    private Storage storage;

    private StageFactory() {
    }

    public static StageFactory getInstance() {
        if (factory == null) {
            synchronized (StageFactory.class) {
                if (factory == null) {
                    factory = new StageFactory();
                }
            }
        }
        return factory;
    }

    public ICommand buildCommand(StageSetter setter, StageCleaner cleaner, StageAnnouncer announcer) {
        return new CommandImpl(setter, cleaner, announcer);
    }

    public StageSetter buildStageSetter(SingletonStage stage) {
        return new StageSetter(stage);
    }

    public StageAnnouncer buildStageAnnouncer(SingletonStage stage) {
        return new StageAnnouncer(stage);
    }

    public StageCleaner buildStageCleaner(SingletonStage stage) {
        return new StageCleaner(stage);
    }

    public SingletonStage buildStage() {
        Tiger bigTigerA = Tiger.Builder.aTiger()
                .withName("A")
                .withCanBoat(true)
                .withSize(Tiger.SIZE.LARGE)
                .build();
        Tiger smallTigerA = Tiger.Builder.aTiger()
                .withName("a")
                .withCanBoat(false)
                .withSize(Tiger.SIZE.SMALL)
                .withParent(bigTigerA)
                .build();
        Tiger bigTigerB = Tiger.Builder.aTiger()
                .withName("B")
                .withCanBoat(true)
                .withSize(Tiger.SIZE.LARGE)
                .build();
        Tiger smallTigerB = Tiger.Builder.aTiger()
                .withName("b")
                .withCanBoat(true)
                .withSize(Tiger.SIZE.SMALL)
                .withParent(bigTigerB)
                .build();
        Tiger bigTigerC = Tiger.Builder.aTiger()
                .withName("C")
                .withCanBoat(true)
                .withSize(Tiger.SIZE.LARGE)
                .build();
        Tiger smallTigerC = Tiger.Builder.aTiger()
                .withName("c")
                .withCanBoat(false)
                .withSize(Tiger.SIZE.SMALL)
                .withParent(bigTigerC)
                .build();
        List<Tiger> tigers = new ArrayList<>();
        tigers.add(bigTigerA);
        tigers.add(bigTigerB);
        tigers.add(bigTigerC);
        tigers.add(smallTigerA);
        tigers.add(smallTigerB);
        tigers.add(smallTigerC);

        Map<String, Tiger> tigerMap = new HashMap<>();
        for (Tiger tiger : tigers) {
            tigerMap.put(tiger.getName(), tiger);
        }
        Region north = Region.Builder.aRegion()
                .withName("North region")
                .withPosition(Region.Position.NORTH)
                .withTigerList(new ArrayList<>())
                .build();
        Region south = Region.Builder.aRegion()
                .withName("South region")
                .withPosition(Region.Position.SOUTH)
                .withTigerList(Lists.newArrayList(tigerMap.values()))
                .build();
        Boat boat = Boat.Builder.aBoat()
                .withName("Boat")
                .withPosition(Region.Position.SOUTH)
                .withTigerList(new ArrayList<>())
                .build();
        List<Region> regions = new ArrayList<>();
        regions.add(boat);
        regions.add(north);
        regions.add(south);

        SingletonStage singletonStage = SingletonStage.getInstance();
        singletonStage.setBoat(boat);
        singletonStage.setSouth(south);
        singletonStage.setNorth(north);
        singletonStage.setRegions(regions);
        singletonStage.setTigerMap(tigerMap);

        storage = new Storage(new Memento(boat.clone(), south.clone(), north.clone()));

        return singletonStage;
    }

    public Storage getStorage() {
        return storage;
    }
}
