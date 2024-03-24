package pk.komp.plaza.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "NOTIFICATION_TYPE")
public class NotificationType {
    @Id
    @Column(name = "Id_NotType", nullable = false)
    private Integer id;

    @Column(name = "NotType_Name", nullable = false, length = 30)
    private String nottypeName;

    @OneToMany(mappedBy = "idNottype")
    private Set<Notification> notifications = new LinkedHashSet<>();

}