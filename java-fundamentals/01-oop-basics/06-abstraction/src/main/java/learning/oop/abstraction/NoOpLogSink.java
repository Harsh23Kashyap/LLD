package learning.oop.abstraction;

/*
 * Another implementation: emit does nothing. Call sites typed as LogSink still compile;
 * behavior changes without changing method signatures on the interface.
 */
public class NoOpLogSink implements LogSink {

    @Override
    public void emit(String line) {
        // intentionally empty
    }
}
