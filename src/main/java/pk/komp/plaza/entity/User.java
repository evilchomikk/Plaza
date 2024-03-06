package pk.komp.plaza.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "USER")
public class User {
    @Id
    @Column(name = "Id_User", nullable = false)
    private Integer id;

    @Column(name = "Username", nullable = false, length = 20)
    private String username;

    @Column(name = "Password", nullable = false, length = 16)
    private String password;

    @Column(name = "Currency", nullable = false, precision = 5, scale = 2)
    private BigDecimal currency;

}