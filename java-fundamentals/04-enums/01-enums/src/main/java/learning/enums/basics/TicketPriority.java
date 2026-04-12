package learning.enums.basics;

/*
 * TicketPriority
 *
 * An enum is a type with a fixed set of named constants (LOW, MEDIUM, HIGH). The compiler
 * treats them like static final fields of the enum type. You can add constructors and methods;
 * each constant can pass constructor arguments, as with slaHours below. Use enums when a
 * value must be one of a known small set instead of a raw string or int code.
 */
public enum TicketPriority {

    LOW(24),
    MEDIUM(8),
    HIGH(1);

    private final int slaHours;

    TicketPriority(int slaHours) {
        this.slaHours = slaHours;
    }

    public int slaHours() {
        return slaHours;
    }
}
