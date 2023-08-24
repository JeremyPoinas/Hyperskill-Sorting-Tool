package sorting;

import java.util.*;

public class SortingLine implements SortingTool {
    List<String> elements;

    public void sort() {
        elements = getList();
        printResults();
    }

    private void printResults() {
        String longest = elements.stream().max(
                Comparator.comparingInt(String::length)
                        .thenComparing(Comparator.reverseOrder()))
                        .orElse(null)
                ;
        long times = Collections.frequency(elements, longest);
        System.out.printf("Total lines: %d.\n", elements.size());
        System.out.printf("The longest line:\n%s\n", longest);
        System.out.printf("(%d time(s), %d%%)", times, times * 100 / elements.size());
    }

    private List<String> getList() {
        Scanner scanner = new Scanner(System.in);
        List<String> elements = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            elements.add(line);
        }
        return elements;
    }
}
