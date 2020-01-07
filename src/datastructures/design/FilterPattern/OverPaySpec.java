package datastructures.design.FilterPattern;

import datastructures.design.FilterPattern.bean.Order;

public class OverPaySpec extends Spec {

    private int value;

    public OverPaySpec(int value) {
        this.value = value;
    }

    @Override
    public boolean isFitByCondition(Order order) {
        return order.getPayValue() > value;
    }
}
