package my.AleksanderMroz.Demo.service.impl;

import my.AleksanderMroz.Demo.repository.ProductRepository;
import my.AleksanderMroz.Demo.service.ProductService;
import my.AleksanderMroz.Demo.to.OpinionTo;
import my.AleksanderMroz.Demo.to.ProductTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    @Override
    public List<OpinionTo> getAllOpinions(ProductTo product) {
        return null;
    }

    @Override
    public ProductTo saveProduct(ProductTo product) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }
}
