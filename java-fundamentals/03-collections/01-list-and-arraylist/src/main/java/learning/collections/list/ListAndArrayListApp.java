package learning.collections.list;

import java.util.ArrayList;
import java.util.List;

/*
 * List and ArrayList
 *
 * List<E> is an interface for an ordered sequence: indexed access, duplicates allowed, size
 * grows as you add elements. It does not say how data is stored.
 *
 * ArrayList<E> is one List implementation: a resizable array. You usually declare variables
 * as List<E> and construct new ArrayList<>() so most code depends on the interface and you
 * can swap implementations later if needed.
 *
 * Common operations: add(element), add(index, element), get(index), set(index, element),
 * remove(index), remove(Object), size(), isEmpty(), clear(). Enhanced for loops work because
 * List implements Iterable.
 */
public final class ListAndArrayListApp {

    private ListAndArrayListApp() {
    }

    public static void main(String[] args) {
        List<String> basket = new ArrayList<>();
        basket.add("apple");
        basket.add("banana");
        basket.add("carrot");

        System.out.println("size=" + basket.size());
        System.out.println("get(0)=" + basket.get(0));

        basket.set(1, "blueberry");
        System.out.println("after set(1): " + basket);

        basket.remove(2);
        System.out.println("after remove(2): " + basket);

        System.out.println("for-each:");
        for (String item : basket) {
            System.out.println("  " + item);
        }
    }
}
