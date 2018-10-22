package my.AleksanderMroz.Demo.service;

import my.AleksanderMroz.Demo.entity.OpinionEntity;
import my.AleksanderMroz.Demo.entity.ProductEntity;
import my.AleksanderMroz.Demo.to.OpinionTo;
import my.AleksanderMroz.Demo.to.ProductTo;

import java.util.List;

public interface ProductService {

    List<OpinionTo> getAllOpinions(ProductTo product);


    ProductTo saveProduct(ProductTo product);
    void deleteProduct(Long id);
}
