package orderState;

public class Test {
    public static void main(String[] args) {
        Order order = new Order("QT001235","测试订单");
        order.setOrderState(Order.newOrderState);
        order.newOrder();
        order.payedOrder();
        order.cancelOrder();
        order.shipedOrder();
        order.shipedOrder();
        order.payedOrder();
    }
}
