
public enum BikeCategory {
    MOUNTAIN("Mountain bike"),
    ROAD("Road bike"),
    HYBRID("Hybrid bike"),
    EBIKE("Electric bike");

    /* fields */
    private String categoryName;

    /* constructor */
    BikeCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    /* accessors */
    public String getBikeCategory() {
        return this.categoryName;
    }

}