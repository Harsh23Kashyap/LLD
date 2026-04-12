package learning.enums.practice;

/*
 * Enums practice — this file (ChipColor.java)
 *
 * Implement opposite():
 * - RED’s opposite is BLACK.
 * - BLACK’s opposite is RED.
 *
 * Use switch (this) { ... } (arrow or classic) on the enum constant, or another clear approach.
 * Remove the placeholder return once the logic matches the rules above.
 */
public enum ChipColor {

    RED,
    BLACK;
    public ChipColor opposite() {
        // TODO
        return ChipColor.RED == this ? ChipColor.BLACK : ChipColor.RED;
    }
}
