package com.felix.state;

import com.felix.manager.IDirector;

/**
 * The base stage state.
 *
 * @author Felix
 */
public abstract class StageState {

    public enum StateType {
        START, NOT_READY, SAIL, STOP
    }

    protected IDirector director;

    public StageState(IDirector director) {
        this.director = director;
    }

    public void handle(StateType state) {
        // Clear the boat before every action.
        director.clear();
    }

    public String toString() {
        return "Current state:" + this.getClass().getSimpleName();
    }

}
