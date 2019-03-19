package orderState;

public class NewOrderState extends OrderState{

    @Override
    public void newOrder() {
        System.out.println("新订单来了...");
    }

    @Override
    public void cancelOrder() {
        super.order.setOrderState(Order.cancelOrderState);
        super.order.cancelOrder();
    }

    @Override
    public void shipedOrder() {

    }

    @Override
    public void payedOrder() {
        super.order.setOrderState(Order.payedOrderState);
        super.order.payedOrder();
    }
}
