package orderState;


public class Order {
    public final static NewOrderState newOrderState = new NewOrderState();
    public final static CancelOrderState cancelOrderState = new CancelOrderState();
    public final static ShipedOrderState shipedOrderState = new ShipedOrderState();
    public final static PayedOrderState payedOrderState = new PayedOrderState();


    private OrderState orderState;
    public OrderState getOrderState() {
        return orderState;
    }
    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
        //把当前的订单通知到各个订单状态中去
        this.orderState.setOrder(this);
    }
    public  void newOrder(){this.orderState.newOrder();}//新订单
    public  void cancelOrder(){this.orderState.cancelOrder();}//取消订单
    public  void shipedOrder(){this.orderState.shipedOrder();}//已邮递
    public  void payedOrder(){this.orderState.payedOrder();}//已支付



    private String id;
    private String desc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Order(String id, String desc) {
        this.id = id;
        this.desc = desc;
    }
}
