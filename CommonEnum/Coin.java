package CommonEnum;

public enum Coin {
    ONE(1),
    FIVE(5),
    TEN(10),
    FIFTY(50);

    private int value;
    Coin(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
