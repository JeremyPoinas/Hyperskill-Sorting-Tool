package sorting;

import java.util.*;

public class SortingInteger implements SortingTool {
    List<Integer> elements;

    public void sort() {
        elements = getList();
        printResults();
    }

    private void printResults() {
        elements.sort(Comparator.naturalOrder());
        System.out.printf("Total numbers: %d.\n", elements.size());
        System.out.print("Sorted data: ");
        elements.forEach(e -> System.out.print(e + " "));
    }

    private List<Integer> getList() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> elements = new ArrayList<>();
        while (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            elements.add(number);
        }
        return elements;
    }
}
