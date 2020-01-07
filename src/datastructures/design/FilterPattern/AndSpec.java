package datastructures.design.FilterPattern;

import datastructures.design.FilterPattern.bean.Order;

public class AndSpec extends Spec {

    private Spec augEndSpec;
    private Spec addEndSpec;

    public AndSpec(Spec augEndSpec, Spec addEndSpec) {
        this.augEndSpec = augEndSpec;
        this.addEndSpec = addEndSpec;
    }

    @Override
    public boolean isFitByCondition(Order order) {
        return augEndSpec.isFitByCondition(order) && addEndSpec.isFitByCondition(order);
    }
}
