package learning.enums.basics;

/*
 * EnumsApp
 *
 * TicketPriority.values() returns every constant in declaration order. valueOf(String) parses
 * the constant name and throws IllegalArgumentException if the name does not match. Switch
 * on an enum is a common way to branch behavior without string compares.
 */
public final class EnumsApp {

    private EnumsApp() {
    }

    private static String label(TicketPriority priority) {
        return switch (priority) {
            case LOW -> "backlog";
            case MEDIUM -> "normal queue";
            case HIGH -> "urgent lane";
        };
    }

    public static void main(String[] args) {
        System.out.println("all constants:");
        for (TicketPriority p : TicketPriority.values()) {
            System.out.println("  " + p.name() + " ordinal=" + p.ordinal() + " slaHours=" + p.slaHours());
        }

        TicketPriority chosen = TicketPriority.HIGH;
        System.out.println();
        System.out.println("valueOf(\"HIGH\") -> " + chosen + " label=" + label(chosen));
    }
}
