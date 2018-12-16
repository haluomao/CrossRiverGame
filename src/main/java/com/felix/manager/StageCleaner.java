package com.felix.manager;

import com.felix.builder.IRegion;
import com.felix.singleton.SingletonStage;
import com.felix.factory.StageFactory;
import com.felix.builder.Tiger;
import com.felix.observer.AbstractObserver;

/**
 * The stage cleaner.
 *
 * @author Felix
 */
public class StageCleaner extends AbstractObserver {

    private SingletonStage stage;

    public StageCleaner(SingletonStage stage) {
        this.stage = stage;
    }

    @Override
    public void handleAccident(Tiger tiger, IRegion region) {
        stage.restoreMemento(StageFactory.getInstance().getStorage().getMemento());
    }
}
