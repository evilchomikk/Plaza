package pk.komp.plaza.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "order_type")
public class OrderType {
    @Id
    @Column(name = "Id_OrderType", nullable = false)
    private Integer id;

    @Column(name = "OrderType_Name", nullable = false, length = 30)
    private String orderTypeName;

}