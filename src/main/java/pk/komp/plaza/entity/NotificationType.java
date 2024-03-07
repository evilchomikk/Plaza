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
@Table(name = "notification_type")
public class NotificationType {
    @Id
    @Column(name = "Id_NotType", nullable = false)
    private Integer id;

    @Column(name = "NotType_Name", nullable = false, length = 30)
    private String notTypeName;

}