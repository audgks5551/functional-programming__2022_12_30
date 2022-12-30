package model;

import java.math.BigDecimal;

public class OrderLine {
    private long id;
    private OrderLineType type;
    private long productId;
    private int quantity;
    private BigDecimal amount;

    public enum OrderLineType {
        PURCHASE,
        DISCOUNT
    }


}
