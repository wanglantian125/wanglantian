package orderState;

public class ShipedOrderState extends OrderState{
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
        System.out.println("订单已邮递了...");
    }

    @Override
    public void payedOrder() {

    }
}
