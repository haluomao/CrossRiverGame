package com.felix.manager;

import java.util.List;

import com.felix.state.StageState;
import com.felix.command.ICommand;

/**
 * The director interface.
 *
 * @author Felix
 */
public interface IDirector {
    /**
     * Please see comments in {@link ICommand}
     */
    void show();

    void countTime();

    void action(List<String> tigers);

    void clear();

    void stop();

    void setState(StageState state);
}
