package my.AleksanderMroz.Demo.entity;


import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "COURIER")
public class CourierEntitiy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String customerName;
    @Column(nullable = false, length = 200)
    private String password;
    @Column(nullable = false, length = 200)
    private String address;



    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "couriers",cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    List<ShipmentEntity> shipments;

}
