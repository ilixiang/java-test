package se;


public enum SeasonEnum {
    SPRING(1, 3, "春"),
    SUMMER(4, 6, "夏"),
    AUTUMN(7, 9, "秋"),
    WINTER(10, 12, "冬");

    private final int fromMonth;
    private final int toMonth;
    private final String desc;

    SeasonEnum(int fromMonth, int toMonth, String desc) {
        this.fromMonth = fromMonth;
        this.toMonth = toMonth;
        this.desc = desc;
    }

    public int getFromMonth() {
        return fromMonth;
    }

    public int getToMonth() {
        return toMonth;
    }

    public String getDesc() {
        return desc;
    }
}
