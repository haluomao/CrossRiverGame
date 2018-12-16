package com.felix.manager;

import java.util.List;

import com.felix.command.ICommand;
import com.felix.state.StageState;
import com.felix.state.StageState.StateType;
import com.felix.state.StartStageState;

/**
 * The excellent director.
 *
 * @author Felix
 */
public class DirectorImpl implements IDirector {
    private ICommand command;
    private StageState state = new StartStageState(this);

    public DirectorImpl(ICommand command) {
        this.command = command;
    }

    @Override
    public void show() {
        command.show();
    }

    @Override
    public void countTime() {
        command.countTime();
    }

    @Override
    public void stop() {
        command.stop();
    }

    @Override
    public void action(List<String> tigers) {
        if (command.ready(tigers)) {
            command.action(tigers);
            boolean hasNext = command.hasNext();
            if (hasNext) {
                state.handle(StateType.SAIL);
            } else {
                state.handle(StateType.STOP);
                state.handle(StateType.START);
            }
        } else {
            state.handle(StateType.NOT_READY);
        }
    }

    @Override
    public void clear() {
        command.clear();
    }

    @Override
    public void setState(StageState state) {
        this.state = state;
    }

}
