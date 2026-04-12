package learning.enums.practice;

/*
 * Enums practice — this file (ChipPracticeApp.java)
 *
 * In main:
 * 1) Print ChipColor.RED.opposite() using System.out.println so it is alone on the first line.
 *    (Printing an enum constant uses its name; you should see BLACK.)
 * 2) Print ChipColor.BLACK.opposite() alone on the second line (you should see RED.)
 *
 * Expected output exactly:
 * BLACK
 * RED
 */
public final class ChipPracticeApp {

    private ChipPracticeApp() {
    }

    public static void main(String[] args) {
        // TODO: two println calls
        System.out.println(ChipColor.RED.opposite());
        System.out.println(ChipColor.BLACK.opposite());
    }
}
