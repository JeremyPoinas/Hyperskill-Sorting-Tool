package sorting;

import java.util.*;

public class SortingWord implements SortingTool {
    List<String> elements;

    public void sort() {
        elements = getList();
        printResults();
    }

    private void printResults() {
        String longest = elements.stream().max(Comparator.comparingInt(String::length).thenComparing(Comparator.reverseOrder())).orElse(null);
        long times = Collections.frequency(elements, longest);
        System.out.printf("Total words: %d.\n", elements.size());
        System.out.printf("The longest word: %s (%d time(s), %d%%)", longest, times, times * 100 / elements.size());
    }

    private List<String> getList() {
        Scanner scanner = new Scanner(System.in);
        List<String> elements = new ArrayList<>();
        while (scanner.hasNext()) {
            String word = scanner.next();
            elements.add(word);
        }
        return elements;
    }
}
