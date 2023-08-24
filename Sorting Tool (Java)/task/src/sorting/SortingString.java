package sorting;


import java.util.*;
import java.util.function.Supplier;

public class SortingString extends SortingTool {
    private final String dataType;
    List<String> elements = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();

    public SortingString(String dataType, String sortingType) {
        super(sortingType);
        this.dataType = dataType;
    }

    @Override
    protected void getElements() {
        Scanner scanner = new Scanner(System.in);
        Supplier<Boolean> hasNext;
        Supplier<String> next;
        if (dataType.equals("line")) {
            hasNext = scanner::hasNextLine;
            next = scanner::nextLine;
        } else {
            hasNext = scanner::hasNext;
            next = scanner::next;
        }

        while (hasNext.get()) {
            String element = next.get();
            if ("natural".equals(sortingType)) {
                elements.add(element);
            } else if ("byCount".equals(sortingType)) {
                map.put(element, map.getOrDefault(element, 0) + 1);
            }
        }
        scanner.close();
    }
    @Override
    protected void sortNatural() {
        elements.sort(Comparator.naturalOrder());
        if ("line".equals(dataType)) {
            System.out.printf("Total lines: %d.\n", elements.size());
            System.out.println("Sorted data: ");
            elements.forEach(System.out::println);
        } else {
            System.out.printf("Total words: %d.\n", elements.size());
            System.out.print("Sorted data: ");
            elements.forEach(e -> System.out.print(e + " "));
        }
    }
    @Override
    protected void sortByCount() {
        Integer totalElements = map.values().stream().reduce(Integer::sum).orElse(1);
        System.out.printf("Total %s: %d.\n",
                "line".equals(dataType) ? "lines" : "words",
                totalElements);
        SortingUtils
                .entriesSortedByValues(map)
                .forEach(e -> System.out.printf("%s: %d times(s), %d%%\n",
                        e.getKey(),
                        e.getValue(),
                        Math.round((float) e.getValue() * 100 / totalElements))
                );
    }
}
