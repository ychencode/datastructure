package datastructures.design.FilterPattern;

import datastructures.design.FilterPattern.bean.Order;

public class BeforeDateSpec extends Spec {
    private long date;

    public BeforeDateSpec(long date) {
        this.date = date;
    }

    @Override
    public boolean isFitByCondition(Order order) {
        return order.getPayTime() < date;
    }
}
