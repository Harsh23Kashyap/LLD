package learning.collections.module3final;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/*
 * Module 3 final — this file (FirstSeenOrder.java)
 *
 * Implement uniqueInScanOrder(List<String> scans):
 * - Return a new LinkedHashSet<String>.
 * - Walk scans from first element to last. Add each sku to the set; LinkedHashSet ignores
 *   duplicates but keeps insertion order, so iterator order matches first time each sku appears.
 * - Empty scans returns an empty set.
 *
 * Remove the placeholder return once the logic is real.
 */
public final class FirstSeenOrder {

    private FirstSeenOrder() {
    }

    public static Set<String> uniqueInScanOrder(List<String> scans) {
        // TODO
        Set<String> unique= new LinkedHashSet<>();

        for(String item:scans) 
            unique.add(item);

        return unique;
    }
}
