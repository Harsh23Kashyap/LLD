package learning.oop.abstraction;

/*
 * Interface
 *
 * Names a contract: which methods exist and their signatures. A class implements the
 * interface with implements and supplies bodies. Variables can be typed as the interface
 * while objects remain concrete, so callers depend on the contract, not one class.
 */
public interface LogSink {

    void emit(String line);
}
