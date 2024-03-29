package pk.komp.plaza.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "CITY")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_City", nullable = false)
    private Integer id;

    @Column(name = "City_Name", nullable = false, length = 60)
    private String cityName;

    @Column(name = "Latitude", nullable = false, precision = 10, scale = 8)
    private BigDecimal latitude;

    @Column(name = "Longitude", nullable = false, precision = 10, scale = 8)
    private BigDecimal longitude;

    @OneToMany(mappedBy = "idCity")
    private Set<Order> orders = new LinkedHashSet<>();

}