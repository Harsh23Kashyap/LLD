package learning.oop.interfaces;

/*
 * InterfacesApp
 *
 * The two static helpers take different interface types. The caller passes the same Product
 * into both: the object satisfies both contracts. That is the point of multiple interfaces
 * on one class—different APIs for different call sites without duplicating objects.
 */
public final class InterfacesApp {

    private InterfacesApp() {
    }

    private static void printId(Identifiable item) {
        System.out.println("Item id: " + item.id());
    }

    private static void printSummary(Summarizable item) {
        System.out.println(item.summary());
    }

    public static void main(String[] args) {
        Product mug = new Product("SKU-1", "Mug", 799);
        printId(mug);
        printSummary(mug);
    }
}
