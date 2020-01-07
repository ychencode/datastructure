package datastructures.design.FilterPattern;

import datastructures.design.FilterPattern.bean.Order;

public class NoLoanSpec extends Spec {

    @Override
    public boolean isFitByCondition(Order order) {
        return !order.isUseLoan();
    }
}
