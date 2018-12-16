package com.felix.state;

import com.felix.manager.IDirector;

/**
 * The sail stage state.
 *
 * @author Felix
 */
public class SailStageState extends StageState {

    public SailStageState(IDirector director) {
        super(director);
    }

    @Override
    public void handle(StateType state) {
        super.handle(state);
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
