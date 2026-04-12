package learning.oop.practice7;

/*
 * Section 7 — this file (Practice7App.java)
 *
 * In main:
 * 1) Create a Priced[] (name it whatever you like) with exactly two elements, in order:
 *    - new Snack("Lay's", 150)
 *    - new BundledSnack(new Snack("Doritos", 200), new Snack("Cheetos", 200))
 *    - new BundledSnack(new Snack("Coca-Cola", 300), new BundledSnack(new Snack("Pepsi", 400), new Snack("Sprite", 500)))
 * 2) Loop over the array with a for-each (for (Priced item : line) { ... }).
 * 3) For each item, print one line: item.sku() + "|" + item.cents() (no extra spaces).
 * 4) Use System.out.println(...) so each item is on its own line.
 *
 * Expected first line: A|150
 * Expected second line: B+Z|400
 */
public final class Practice7App {

    private Practice7App() {
    }

    public static void main(String[] args) {
        // TODO: Priced[] + loop + println per line
        Priced[] line = {
            new Snack("Lay's", 150),
            new BundledSnack(new Snack("Doritos", 200), new Snack("Cheetos", 200)),
            new BundledSnack(new Snack("Coca-Cola", 300), new BundledSnack(new Snack("Pepsi", 400), new Snack("Sprite", 500)))
        };
        for (Priced lineItem: line) {
            System.out.println(lineItem.sku() + "|" + lineItem.cents());
        }
    }
}
