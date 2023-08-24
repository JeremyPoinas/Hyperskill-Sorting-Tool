package sorting;

import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortingUtils {
    static <K extends Comparable<? super K>, V extends Comparable<? super V>>
    SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K,V> map) {
        SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<>(
                Map.Entry.<K, V>comparingByValue().thenComparing(Map.Entry::getKey)
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }
}
