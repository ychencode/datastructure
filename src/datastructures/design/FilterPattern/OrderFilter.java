package datastructures.design.FilterPattern;

import datastructures.design.FilterPattern.bean.Order;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OrderFilter {

    private List<Order> orders = new ArrayList<Order>();

    public void addOrder(Order order) {
        orders.add(order);
    }

    private List<Order> selectBy(Spec spec) {
        List<Order> list = new ArrayList<Order>();
        Iterator iterator = orders.iterator();
        while (iterator.hasNext()) {
            Order order = (Order) iterator.next();
            if (spec.isFitByCondition(order)) {
                list.add(order);
            }
        }
        return list;
    }

    // 返回没有使用过贷款的订单
    public List<Order> getNoUseLoan() {
        return selectBy(new NoLoanSpec());
    }

    // 返回在这个日期之前的订单
    public List<Order> beforeDate(long date) {
        return selectBy(new BeforeDateSpec(date));
    }

    // 返回在这个日期之前，且金额大于固定值的订单
    public List<Order> beforeDateAndOverValue(long date, int payValue) {
        return selectBy(new AndSpec(new BeforeDateSpec(date), new OverPaySpec(payValue)));
    }

    // 返回支付金额大于固定值且是用微信支付的订单
    public List<Order> overPayAndUseWechat(int payValue) {
        return selectBy(new AndSpec(new UseWechatSpec(), new OverPaySpec(payValue)));
    }
}
