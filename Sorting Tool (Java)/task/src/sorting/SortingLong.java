package sorting;


import java.util.*;

public class SortingLong extends SortingTool {
    List<Long> elements = new ArrayList<>();
    Map<Long, Integer> map = new HashMap<>();

    public SortingLong(String sortingType) {
        super(sortingType);
    }
    @Override
    protected void sortByCount() {
        Integer totalLongs = map.values().stream().reduce(Integer::sum).orElse(1);
        System.out.printf("Total numbers: %d.\n", totalLongs);
        SortingUtils
                .entriesSortedByValues(map)
                .forEach(e -> System.out.printf("%s: %d times(s), %d%%\n",
                        e.getKey(),
                        e.getValue(),
                        Math.round((float) e.getValue() * 100 / totalLongs))
                );
    }
    @Override
    protected void sortNatural() {
        elements.sort(Comparator.naturalOrder());
        System.out.printf("Total words: %d.\n", elements.size());
        System.out.print("Sorted data: ");
        elements.forEach(e -> System.out.print(e + " "));
    }
    @Override
    protected void getElements() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLong()) {
            long number = scanner.nextLong();
            if ("natural".equals(sortingType)) {
                elements.add(number);
            } else if ("byCount".equals(sortingType)) {
                map.put(number, map.getOrDefault(number, 0) + 1);
            }
        }
    }
}
