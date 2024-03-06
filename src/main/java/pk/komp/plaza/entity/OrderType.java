package pk.komp.plaza.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "ORDER_TYPE")
public class OrderType {
    @Id
    @Column(name = "Id_OrderType", nullable = false)
    private Integer id;

    @Column(name = "OrderType_Name", nullable = false, length = 30)
    private String ordertypeName;

    @OneToMany(mappedBy = "idOrdertype")
    private Set<Order> orders = new LinkedHashSet<>();

}