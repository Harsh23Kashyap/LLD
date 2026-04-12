package learning.collections.module3final;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
/*
 * Module 3 final — this file (CollectionsFinalApp.java)
 *
 * Wire together List + Map + Set from this module.
 *
 * 1) Create ArrayList<String> scans. Add strings in this exact order: A, B, A, C, B
 *    (use the literal "A" etc., five add calls).
 *
 * 2) Print exactly one line (no extra spaces around commas):
 *      scans: A,B,A,C,B
 *
 * 3) Map<String, Integer> tallies = ScanTally.tally(scans);
 *
 * 4) Print exactly:
 *      counts:
 *    Then one line per sku in alphabetical order by sku, each line preceded by exactly two
 *    spaces, format "SK -> N" where SK is the sku and N is the count (use TreeMap<String,Integer>
 *    constructed from tallies so key iteration is sorted). Expected lines after "counts:":
 *        A -> 2
 *        B -> 2
 *        C -> 1
 *
 * 5) Set<String> first = FirstSeenOrder.uniqueInScanOrder(scans);
 *
 * 6) Print exactly one line:
 *      first-seen: A,B,C
 *    (comma separated, no spaces after commas; order must match first occurrence in scans.)
 *
 * 7) No other output lines.
 */
public final class CollectionsFinalApp {

    private CollectionsFinalApp() {
        
    }
    public static void main(String[] args) {
        List<String> scans = new ArrayList<>();
        scans.add("A");
        scans.add("B");
        scans.add("A");
        scans.add("C");
        scans.add("B");

        System.out.println("scans: " + scans);
        Map<String, Integer> tallies = ScanTally.tally(scans);
        System.out.println("counts: ");
        for(Map.Entry<String, Integer> entry: tallies.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }
        Set<String> first = FirstSeenOrder.uniqueInScanOrder(scans);
        System.out.println("first-seen: " + first);
        for(String item: first) {
            System.out.println("  " + item);
        }
        System.out.println();
        System.out.println();
    }
}
