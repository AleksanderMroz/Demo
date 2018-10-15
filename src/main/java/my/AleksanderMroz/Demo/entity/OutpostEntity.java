package my.AleksanderMroz.Demo.entity;


import my.AleksanderMroz.Demo.enumeration.Cities;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Entity
@Table(name = "OUTPOST")
@Proxy(lazy=false)
public class OutpostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false, length = 50)
    private String logo;

    @Enumerated(EnumType.STRING)
    private Cities location;

    public OutpostEntity() {
    }

    public OutpostEntity(Long id, String logo, Cities location) {
        this.id = id;
        this.logo = logo;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Cities getLocation() {
        return location;
    }

    public void setLocation(Cities location) {
        this.location = location;
    }
}
