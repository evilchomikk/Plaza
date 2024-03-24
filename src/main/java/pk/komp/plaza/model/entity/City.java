package pk.komp.plaza.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "CITY")
public class City {
    @Id
    @Column(name = "Id_City", nullable = false)
    private Integer id;

    @Column(name = "City_Name", nullable = false, length = 60)
    private String cityName;

    @OneToMany(mappedBy = "idCity")
    private Set<Order> orders = new LinkedHashSet<>();

}