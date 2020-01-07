package datastructures.design.FilterPattern;

import datastructures.design.FilterPattern.bean.Order;

public class UseWechatSpec extends Spec {

    @Override
    public boolean isFitByCondition(Order order) {
        return order.getType() == Order.PAY_TYPE_WECHAT;
    }
}
