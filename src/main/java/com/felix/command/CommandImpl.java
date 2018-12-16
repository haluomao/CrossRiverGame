package com.felix.command;

import java.util.List;

import com.felix.manager.StageAnnouncer;
import com.felix.manager.StageCleaner;
import com.felix.manager.StageSetter;

/**
 * The command impl.
 *
 * @author Felix
 */
public class CommandImpl implements ICommand {

    private StageSetter setter;
    private StageCleaner cleaner;
    private StageAnnouncer announcer;

    public CommandImpl(StageSetter stageSetter, StageCleaner cleaner,
            StageAnnouncer announcer) {
        this.setter = stageSetter;
        this.cleaner = cleaner;
        this.announcer = announcer;
    }

    @Override
    public void countTime() {
        setter.countTime();
    }

    @Override
    public boolean ready(List<String> tigers) {
        return setter.checkReady(tigers);
    }

    @Override
    public void clear() {
        setter.clearBoat();
    }

    @Override
    public void action(List<String> tigers) {
        setter.sail(tigers);
    }

    @Override
    public boolean hasNext() {
        return setter.checkSafe() && !setter.checkDone();
    }

    @Override
    public void show() {
        announcer.printStage();
    }

    @Override
    public void stop() {
        cleaner.handleAccident(null, null);
    }
}
