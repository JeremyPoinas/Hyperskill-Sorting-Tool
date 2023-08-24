package sorting;

public abstract class SortingTool {
    protected final String sortingType;

    public SortingTool(String sortingType) {
        this.sortingType = sortingType;
    }

    void sort() {
        getElements();
        switch (sortingType) {
            case "natural" -> sortNatural();
            case "byCount" -> sortByCount();
        }
    }

    protected void getElements() {
    }

    protected void sortByCount() {
    }

    protected void sortNatural() {
    }
}
