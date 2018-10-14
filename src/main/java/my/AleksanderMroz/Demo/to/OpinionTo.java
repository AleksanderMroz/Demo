package my.AleksanderMroz.Demo.to;

import my.AleksanderMroz.Demo.entity.CustomerEntity;
import my.AleksanderMroz.Demo.entity.ProductEntity;


public class OpinionTo {


    private Long id;
    private String description;
    private ProductEntity described_product;
    private CustomerEntity customer_id;

    public OpinionTo() {
    }

    public OpinionTo(Long id, String description, ProductEntity described_product, CustomerEntity customer_id) {
        this.id = id;
        this.description = description;
        this.described_product = described_product;
        this.customer_id = customer_id;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public ProductEntity getDescribed_product() {
        return described_product;
    }

    public CustomerEntity getCustomer_id() {
        return customer_id;
    }
}
