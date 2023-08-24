package sorting;

public class SortingContext {
    String sortingType;
    String dataType;
    public SortingContext(String sortingType, String dataType) {
        this.sortingType = sortingType;
        this.dataType = dataType;
    }

    SortingTool createSortingTool() {
        if (dataType.equals("long")) {
            return new SortingLong(sortingType);
        }
        return new SortingString(dataType, sortingType);
    }
}
