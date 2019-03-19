package orderState;


public abstract class OrderState {
    protected Order order;

    public void setOrder(Order order) {
        this.order = order;
    }
    public abstract void newOrder();//新订单
    public abstract void cancelOrder();//取消订单
    public abstract void shipedOrder();//已邮递
    public abstract void payedOrder();//已支付

}
