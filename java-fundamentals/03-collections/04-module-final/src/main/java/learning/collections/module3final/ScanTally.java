package learning.collections.module3final;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Module 3 final — this file (ScanTally.java)
 *
 * Implement tally(List<String> scans):
 * - Return a new HashMap<String, Integer>.
 * - For each string in scans (in order), treat it as a sku and increment its count in the map
 *   (missing key starts at 0, then becomes 1, 2, ...).
 * - An empty scans list returns an empty map.
 *
 * Remove the placeholder return once the logic is real.
 */
public final class ScanTally {

    private ScanTally() {
    }

    public static Map<String, Integer> tally(List<String> scans) {
        // TODO
        Map<String,Integer> tally = new HashMap<>();

        //Approach 1: Using get and put
        // for (String item:scans) {
        //     if(tally.containsKey(item)){
        //         int value=tally.get(item);
        //         tally.put(item, value+1);
        //     }else{
        //         tally.put(item, 1);
        //     }
        // }


        for(String item:scans) {
            tally.put(item, tally.getOrDefault(item, 0)+1);
        }


        return tally;
    }
}
