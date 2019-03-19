package orderState;

public class CancelOrderState extends OrderState{

    @Override
    public void newOrder() {

    }

    @Override
    public void cancelOrder() {
        System.out.println("订单取消了...");
    }

    @Override
    public void shipedOrder() {

    }

    @Override
    public void payedOrder() {

    }
}
