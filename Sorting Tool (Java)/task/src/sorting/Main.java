package sorting;

import java.io.*;
import java.util.List;

public class Main {
    static final String PATH = System.getProperty("user.dir") + "\\";
    static String dataType;
    static String sortingType;

    public static void main(final String[] args) {
        try {
            setArguments(args);
            checkArguments();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        var sortingContext = new SortingContext(sortingType, dataType);
        SortingTool sortingTool = sortingContext.createSortingTool();
        sortingTool.sort();
    }

    private static void setArguments(String[] args) throws FileNotFoundException {
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-sortingType" -> {
                    if (i + 1 >= args.length || args[i + 1].startsWith("-")) {
                        throw new IllegalArgumentException("No sorting type defined!");
                    }
                    sortingType = args[i + 1];
                }
                case "-dataType" -> {
                    if (i + 1 >= args.length || args[i + 1].startsWith("-")) {
                        throw new IllegalArgumentException("No data type defined!");
                    }
                    dataType = args[i + 1];
                }
                case "-inputFile" -> System.setIn(new FileInputStream(PATH + args[i + 1]));
                case "-outputFile" -> System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(PATH + args[i+ 1])), true));
                default -> {
                    if (args[i].startsWith("-")) {
                        System.out.printf("\"%s\" is not a valid parameter. It will be skipped.\n", args[i]);
                    }
                }
            }
        }
        if (sortingType == null) {
            sortingType = "natural";
        }
        if (dataType == null) {
            dataType = "line";
        }
    }

    private static void checkArguments() {
        List<String> authSortingTypes = List.of("natural", "byCount");
        List<String> authDataTypes = List.of("long", "word", "line");

        if (!authSortingTypes.contains(sortingType)) {
            throw new IllegalArgumentException("Wrong parameter for -sortingType!");
        }
        if (!authDataTypes.contains(dataType)) {
            throw new IllegalArgumentException("Wrong parameter for -dataType!");
        }
    }
}

