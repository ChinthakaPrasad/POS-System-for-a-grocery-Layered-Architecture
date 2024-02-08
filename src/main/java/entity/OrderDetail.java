package entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class OrderDetail {
    private String orderID;
    private String itemCode;
    private int qty;
    private double unitPrice;
}
