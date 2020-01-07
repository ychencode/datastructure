package datastructures.design.FilterPattern;

import datastructures.design.FilterPattern.bean.Order;

public abstract class Spec {
    public abstract boolean isFitByCondition(Order order);
}
