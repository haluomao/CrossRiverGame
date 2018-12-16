package com.felix.state;

import com.felix.manager.IDirector;

/**
 * The start stage state.
 *
 * @author Felix
 */
public class StartStageState extends StageState {

    public StartStageState(IDirector director) {
        super(director);
    }

    @Override
    public void handle(StateType state) {
        super.handle(state);
        director.countTime();
        switch (state) {
            case NOT_READY:
                break;
            case SAIL:
                director.setState(new SailStageState(director));
                break;
            case STOP:
                director.stop();
                director.setState(new StopStageState(director));
                break;
            default:
                throw new IllegalArgumentException("Wrong state:" + state + ", current state:"
                        + this.getClass().getSimpleName());
        }
    }
}
