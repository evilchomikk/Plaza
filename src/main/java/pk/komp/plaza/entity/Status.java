package pk.komp.plaza.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "STATUSES")
public class Status {
    @Id
    @Column(name = "Id_Statuses", nullable = false)
    private Integer id;

    @Column(name = "Statuses_Name", nullable = false, length = 30)
    private String statusesName;

    @OneToMany(mappedBy = "idStatuses")
    private Set<Order> orders = new LinkedHashSet<>();

}