package entity;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class Orders {
    private String id;
    private String date;
    private String customerId;
}
