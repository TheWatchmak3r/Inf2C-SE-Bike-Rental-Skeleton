

public enum BikeCategory {
    MOUNTAIN("mountain bike"),
    ROAD("road bike"),
    HYBRID("hybrid bike"),
    EBIKE("electric bike");

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