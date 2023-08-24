package sorting;

public class Main {
    public static void main(final String[] args) {
        String dataType = "-dataType".equals(args[0]) ? args[1] : "word";
        SortingToolFactory sortingToolFactory = new SortingToolFactory();
        SortingTool sortingTool = sortingToolFactory.createSortingTool(dataType);
        sortingTool.sort();
    }
}

