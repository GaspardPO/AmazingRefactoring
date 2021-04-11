public enum CellType {
    CLOSE_RIGHT_BOTTOM("  I", ":--"),
    CLOSE_RIGHT("  I", ":  "),
    CLOSE_BOTTOM("   ", ":--"),
    OPEN("   ", ":  ");

    final String right;
    final String bottom;

    CellType(String right, String bottom) {
        this.right = right;
        this.bottom = bottom;
    }
}