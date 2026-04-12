package learning.oop.abstraction;

/*
 * One implementation of LogSink. Other classes can take a LogSink parameter and work with
 * any implementation that obeys emit's meaning.
 */
public class ConsoleLogSink implements LogSink {

    @Override
    public void emit(String line) {
        System.out.println(line);
    }
}
