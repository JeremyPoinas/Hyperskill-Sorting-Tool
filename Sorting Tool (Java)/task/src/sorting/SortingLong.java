package sorting;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortingLong implements SortingTool {
    List<Long> elements;

    public void sort() {
        elements = getList();
        printResults();
    }

    private void printResults() {
        long greatest = Collections.max(elements);
        long times = Collections.frequency(elements, greatest);
        System.out.printf("Total numbers: %d.\n", elements.size());
        System.out.printf("The greatest number: %d (%d time(s), %d%%).", greatest, times, times * 100 / elements.size());
    }

    private List<Long> getList() {
        Scanner scanner = new Scanner(System.in);
        List<Long> elements = new ArrayList<>();
        while (scanner.hasNextLong()) {
            long number = scanner.nextLong();
            elements.add(number);
        }
        return elements;
    }
}
