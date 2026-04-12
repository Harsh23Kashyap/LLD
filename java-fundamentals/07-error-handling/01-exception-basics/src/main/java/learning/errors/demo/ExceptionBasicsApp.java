package learning.errors.demo;

/*
 * Exception basics
 *
 * try — run code that might throw an exception.
 * catch (SomeType ex) — if a matching throwable is thrown, jump here instead of crashing the
 * thread. You can read ex.getMessage() or ex.printStackTrace() while handling.
 * finally — runs after the try finishes normally, or after a catch finishes, or even if the
 * try returns (unless the JVM exits first). Use it for cleanup you always need.
 *
 * This lesson uses runtime exceptions (unchecked): you are not forced to declare them on
 * every method. Checked exceptions (like IOException) must be declared with throws or handled;
 * that is a separate lesson path when you work with files and APIs that declare checked types.
 */
public final class ExceptionBasicsApp {

    private ExceptionBasicsApp() {
    }

    private static int divide(int a, int b) throws IllegalArgumentException {
        if (b == 0) {
            throw new IllegalArgumentException("b must be non-zero");
        }
        return a / b;
    }

    public static void main(String[] args) {
        try {
            int ok = Integer.parseInt("42");
            System.out.println("parsed: " + ok);
        } catch (NumberFormatException ex) {
            System.out.println("not a number: " + ex.getMessage());
        }

        try {
            int bad = Integer.parseInt("42x");
            System.out.println("never reached: " + bad);
        } catch (NumberFormatException ex) {
            System.out.println("not a number: " + ex.getMessage());
        }

        try {
            System.out.println("divide ok: " + divide(10, 2));
            System.out.println("divide bad: " + divide(3, 0));
        } catch (IllegalArgumentException ex) {
            System.out.println("caught: " + ex.getMessage());
        } finally {
            System.out.println("finally after divide try");
        }
    }
}
