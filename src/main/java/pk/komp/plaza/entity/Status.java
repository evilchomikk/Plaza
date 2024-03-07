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
@Table(name = "statuses")
public class Status {
    @Id
    @Column(name = "Id_Statuses", nullable = false)
    private Integer id;

    @Column(name = "Statuses_Name", nullable = false, length = 30)
    private String statusesName;

}