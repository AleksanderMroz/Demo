package my.AleksanderMroz.Demo.entity;


import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Entity
@Table(name="OPINION")
@Proxy(lazy=false)
public class OpinionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 3000)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ID_PRODUCT")
    private ProductEntity described_product;

    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ID_CUSTOMER")
    private CustomerEntity customer_id;




    public OpinionEntity() {
    }

    public OpinionEntity(Long id, String description, ProductEntity described_product, CustomerEntity opinion_id) {
        this.id = id;
        this.description = description;
        this.described_product = described_product;
        this.customer_id = opinion_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductEntity getDescribed_product() {
        return described_product;
    }

    public void setDescribed_product(ProductEntity described_product) {
        this.described_product = described_product;
    }

    public CustomerEntity getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(CustomerEntity opinion_id) {
        this.customer_id = opinion_id;
    }
}
