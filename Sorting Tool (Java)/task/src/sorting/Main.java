package sorting;

public class Main {
    public static void main(final String[] args) {
        String dataType = "word";
        loop: for (int i = 0; i < args.length; i++)
            switch (args[i]) {
                case "-sortIntegers" -> {
                    dataType = "integer";
                    break loop;
                }
                case "-dataType" -> dataType = args[i + 1];
            }
        var sortingToolFactory = new SortingToolFactory();
        SortingTool sortingTool = sortingToolFactory.createSortingTool(dataType);
        sortingTool.sort();
    }
}

