public enum CellType {
    /*
      I
    :--
     */
    CLOSE_RIGHT_BOTTOM(0),

    /*
      I
    :
     */
    CLOSE_RIGHT(1),

    /*

    :--
     */
    CLOSE_BOTTOM(2),
    OPEN(3);


    private int value;

    public int getValue() {
        return value;
    }

    CellType(int value) {
        this.value = value;
    }
}