package learning.collections.map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/*
 * Map, HashMap, LinkedHashMap, TreeMap
 *
 * Map<K, V> is still the interface: unique keys, one value per key, put replaces an existing
 * key. The three classes below are different Map implementations; they agree on get/put/remove
 * behavior but differ in how entries are stored and in what order entrySet() / keySet()
 * visits keys when you iterate.
 *
 * In C++, HashMap will be like unordered_map<K, V>.
 * In C++, LinkedHashMap will be like nothing. Nothing based on insertion order.
 * In C++, TreeMap will be like map<K, V> sorted by keys.
 *
 * HashMap — backing store is a hash table (buckets). Average-case O(1) get and put. Iteration
 * order is not specified and can change if the table resizes or between JVM runs. Use it when
 * you only care about fast lookup by key, not order.
 *
 * LinkedHashMap — extends HashMap and adds a doubly-linked list threading the entries in
 * insertion order (by default). Slightly more memory and work per mutating operation. Use it
 * when you want predictable iteration order matching the order you put keys in (or LRU if
 * you configure access-order, not shown here).
 *
 * TreeMap — backing store is a red-black tree sorted by keys. get/put are O(log n). Iteration
 * visits keys in sorted order (String uses dictionary order unless you pass a Comparator).
 * Keys must be mutually comparable (Comparable interface) or you supply a Comparator. Use it
 * when you need sorted keys or range views (subMap, etc.).
 */
public final class MapAndHashMapApp {

    private MapAndHashMapApp() {
    }

    private static void printKeyOrder(String title, Map<String, Integer> map) {
        System.out.println(title);
        // We use a StringBuilder here to efficiently build a comma-separated list
        // of keys without creating multiple intermediate Strings in a loop.
        StringBuilder keys = new StringBuilder();
        for (String key : map.keySet()) {
            if (keys.length() > 0) {
                keys.append(", ");
            }
            keys.append(key);
        }
        System.out.println("  key iteration order: " + keys);
        System.out.println("  toString: " + map);
        System.out.println();
    }

    private static void fillSameInserts(Map<String, Integer> target) {
        // Same three puts in the same order for every map type.
        target.put("gamma", 3);
        target.put("alpha", 1);
        target.put("beta", 2);
    }

    public static void main(String[] args) {
        System.out.println("=== Same inserts: gamma, alpha, beta ===");
        System.out.println();

        Map<String, Integer> hash = new HashMap<>();
        fillSameInserts(hash);
        printKeyOrder("HashMap (order not promised; often looks random)", hash);

        Map<String, Integer> linked = new LinkedHashMap<>();
        fillSameInserts(linked);
        printKeyOrder("LinkedHashMap (insertion order: gamma, then alpha, then beta)", linked);

        Map<String, Integer> treeNatural = new TreeMap<>();
        fillSameInserts(treeNatural);
        printKeyOrder("TreeMap (sorted by key: String natural order)", treeNatural);

        Map<String, Integer> treeReverse = new TreeMap<>(Comparator.reverseOrder());
        fillSameInserts(treeReverse);
        printKeyOrder("TreeMap with Comparator.reverseOrder() on keys", treeReverse);

        System.out.println("=== Basic HashMap API (put replaces key) ===");
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Ada", 98);
        scores.put("Bob", 87);
        scores.put("Ada", 100);
        System.out.println("size=" + scores.size() + " Ada -> " + scores.get("Ada"));
        scores.put("Carol", 91);
        scores.remove("Bob");
        System.out.println("after updates: " + scores);
        System.out.println("entry loop:");
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            System.out.println("  " + entry.getKey() + " => " + entry.getValue());
        }

        // Using forEach method (Java 8+)
        for (String key : scores.keySet()) {
            System.out.println("  " + key + " => " + scores.get(key));
        }

        // Using forEach method (Java 8+)
        scores.forEach((key, value) -> System.out.println("  " + key + " => " + value));
    }
}
