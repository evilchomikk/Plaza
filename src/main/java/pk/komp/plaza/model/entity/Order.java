package pk.komp.plaza.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "Id_OrderMaker", nullable = false)
    private User idOrdermaker;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "Id_OrderTaker")
    private User idOrdertaker;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "Id_OrderType", nullable = false)
    private OrderType idOrdertype;

    @Column(name = "End_Date_Order", nullable = false)
    private Instant endDateOrder;

    @Column(name = "Value", nullable = false, precision = 10, scale = 2)
    private BigDecimal value;

    @Column(name = "Start_Date_Order", nullable = false)
    private Instant startDateOrder;

    @Column(name = "isActive", nullable = false)
    private Short isActive;

}