package com.felix.command;

import java.util.List;

/**
 * The command interface.
 * Those commands will be called by director.
 *
 * @author Felix
 */
public interface ICommand {
    /**
     * Begin to count down time.
     */
    void countTime();

    /**
     * Check sailors are ready.
     *
     * @param tigers sailors.
     * @return true if ready, false otherwise.
     */
    boolean ready(List<String> tigers);

    /**
     * Clear stage for next action.
     */
    void clear();

    /**
     * Sail to cross bank!
     *
     * @param tigers sailors.
     */
    void action(List<String> tigers);

    /**
     * Check there exists next action.
     *
     * @return true if exist, false otherwise.
     */
    boolean hasNext();

    /**
     * Print stage.
     */
    void show();

    /**
     * Stop and clean stage.
     */
    void stop();
}
