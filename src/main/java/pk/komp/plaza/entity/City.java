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
@Table(name = "city")
public class City {
    @Id
    @Column(name = "Id_City", nullable = false)
    private Integer id;

    @Column(name = "City_Name", nullable = false, length = 60)
    private String cityName;

}