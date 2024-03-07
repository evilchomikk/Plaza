package pk.komp.plaza.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "Id_Order", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "Id_City", nullable = false)
    private City idCity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "Id_Statuses", nullable = false)
    private Status idStatuses;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "Id_OrderType", nullable = false)
    private OrderType idOrderType;

    @Column(name = "End_Date_Order", nullable = false)
    private Instant endDateOrder;

    @Column(name = "Start_Date_Order", nullable = false)
    private Instant startDateOrder;

    @Column(name = "isActive", nullable = false)
    private Short isActive;

}