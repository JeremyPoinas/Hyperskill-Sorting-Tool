package sorting;

public class Main {
    public static void main(final String[] args) {
        String dataType = "word";
        String sortingType = "natural";
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-sortingType" -> sortingType = args[i + 1];
                case "-dataType" -> dataType = args[i + 1];
            }
        }
        var sortingContext = new SortingContext(sortingType, dataType);
        SortingTool sortingTool = sortingContext.createSortingTool();
        sortingTool.sort();
    }
}

