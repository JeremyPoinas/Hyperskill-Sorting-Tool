package sorting;

public class SortingToolFactory {

    SortingTool createSortingTool(String dataType) {
        switch (dataType) {
            case "integer" -> {
                return new SortingInteger();
            }
            case "long" -> {
                return new SortingLong();
            }
            case "line" -> {
                return new SortingLine();
            }
            default -> {
                return new SortingWord();
            }
        }
    }
}
