package my.AleksanderMroz.Demo.entity;


import my.AleksanderMroz.Demo.enumeration.Cities;

import javax.persistence.*;

@Entity
@Table(name = "OUTPOST")
public class OutpostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false, length = 50)
    private String logo;

    @Enumerated(EnumType.STRING)
    private Cities location;






}
