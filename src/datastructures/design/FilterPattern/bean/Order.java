package datastructures.design.FilterPattern.bean;

public class Order {

    public static final Integer PAY_TYPE_WECHAT = 1;

    private long payTime;
    private boolean useLoan;
    private int payValue;
    private int type;

    public Order() {
    }

    public Order(long payTime, boolean useLoan, int payValue, int type) {
        this.payTime = payTime;
        this.useLoan = useLoan;
        this.payValue = payValue;
        this.type = type;
    }

    public long getPayTime() {
        return payTime;
    }

    public boolean isUseLoan() {
        return useLoan;
    }

    public int getPayValue() {
        return payValue;
    }

    public int getType() {
        return type;
    }
}
