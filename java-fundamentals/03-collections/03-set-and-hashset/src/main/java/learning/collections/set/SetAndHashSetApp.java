package learning.collections.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.Comparator;

/*
 * Set and HashSet
 *
 * Set<E> describes a collection with no duplicate elements. add(x) leaves the set unchanged
 * if an equal element is already stored (HashSet.add returns false in that case). There is no
 * get(index); membership is tested with contains. Size is the count of distinct elements.
 *
 * In C++, HashSet will be like unordered_set<E>.
 * HashSet<E> stores elements in a hash table. Average-time add, remove, and contains are
 * constant. Iteration order is not specified and can look arbitrary. Elements should obey
 * equals and hashCode together (for String and Integer they already do).
 *
 * In C++, LinkedHashSet will be like nothing. Nothing based on insertion order.
 * LinkedHashSet preserves insertion order (hash table plus linked list). TreeSet keeps a
 * sorted set (red-black tree) and requires Comparable keys or a Comparator. The small
 * comparison at the bottom of main mirrors the Map lesson: same adds, different iteration order.
 * 
 * In C++, TreeSet will be like set<E> sorted by keys.
 * TreeSet preserves insertion order (red-black tree) and requires Comparable keys or a Comparator.
 * TreeSet keeps a sorted set (red-black tree) and requires Comparable keys or a Comparator. The small

*/
public final class SetAndHashSetApp {

    private SetAndHashSetApp() {
    }

    private static void printSet(String title, Set<String> set) {
        System.out.println(title + " -> " + set);
    }

    public static void main(String[] args) {
        Set<String> tags = new HashSet<>();
        boolean first = tags.add("java");
        boolean second = tags.add("rust");
        boolean duplicate = tags.add("java");

        System.out.println("add java first time: " + first);
        System.out.println("add rust: " + second);
        System.out.println("add java again: " + duplicate + " (false means duplicate ignored)");
        System.out.println("size=" + tags.size());
        System.out.println("contains rust=" + tags.contains("rust"));

        tags.remove("rust");
        System.out.println("after remove rust: " + tags);

        System.out.println("iterate:");
        for (String tag : tags) {
            System.out.println("  " + tag);
        }

        System.out.println();
        System.out.println("=== Same adds: gamma, alpha, beta ===");
        Set<String> hash = new HashSet<>();
        hash.add("gamma");
        hash.add("alpha");
        hash.add("beta");
        printSet("HashSet (order not promised)", hash);

        Set<String> linked = new LinkedHashSet<>();
        linked.add("gamma");
        linked.add("alpha");
        linked.add("beta");
        printSet("LinkedHashSet (insertion order)", linked);

        Set<String> tree = new TreeSet<>();
        // Uncomment this to sort in reverse order
        // Set<String> tree = new TreeSet<>(Comparator.reverseOrder());
        tree.add("gamma");
        tree.add("alpha");
        tree.add("beta");
        printSet("TreeSet (sorted keys)", tree);

    // Loop through a set using for-each and print each element
    System.out.println();
    System.out.println("Looping through TreeSet:");
    for (String tag : tree) {
        System.out.print("  " + tag);
    }
    System.out.println();
    }
}
