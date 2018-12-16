package com.felix.facade;

import java.util.List;

import com.felix.singleton.SingletonStage;
import com.felix.factory.StageFactory;
import com.felix.manager.DirectorImpl;
import com.felix.manager.IDirector;
import com.felix.manager.StageAnnouncer;
import com.felix.manager.StageCleaner;
import com.felix.manager.StageSetter;
import com.felix.state.StartStageState;

/**
 * The implement of {@link IFacade}.
 *
 * @author Felix
 */
public class FacadeImpl implements IFacade {

    private SingletonStage stage;
    private IDirector director;

    public FacadeImpl() {
        StageFactory factory = StageFactory.getInstance();
        stage = factory.buildStage();
        StageSetter setter = factory.buildStageSetter(stage);
        StageCleaner cleaner = factory.buildStageCleaner(stage);
        StageAnnouncer announcer = factory.buildStageAnnouncer(stage);
        setter.registerObserver(announcer);
        setter.registerObserver(cleaner);
        director = new DirectorImpl(factory.buildCommand(setter, cleaner, announcer));
        director.setState(new StartStageState(director));
    }

    @Override
    public void show() {
        director.show();
    }

    @Override
    public void sail(List<String> tigerNames) {
        director.action(tigerNames);
    }
}
