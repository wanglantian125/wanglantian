package orderState;

public class PayedOrderState extends OrderState{
    @Override
    public void newOrder() {

    }

    @Override
    public void cancelOrder() {
        super.order.setOrderState(Order.cancelOrderState);
        super.order.cancelOrder();
    }

    @Override
    public void shipedOrder() {
        super.order.setOrderState(Order.shipedOrderState);
        super.order.shipedOrder();
    }

    @Override
    public void payedOrder() {
        System.out.println("订单已经支付了...");
    }
}
