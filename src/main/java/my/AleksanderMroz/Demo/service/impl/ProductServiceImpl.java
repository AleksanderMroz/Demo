package my.AleksanderMroz.Demo.service.impl;

import my.AleksanderMroz.Demo.entity.CourierEntitiy;
import my.AleksanderMroz.Demo.entity.ProductEntity;
import my.AleksanderMroz.Demo.mapper.CourierMapper;
import my.AleksanderMroz.Demo.mapper.OpinionMapper;
import my.AleksanderMroz.Demo.mapper.ProductMapper;
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


        return OpinionMapper.map2To(productRepository.getAllOpinions(ProductMapper.map(product)));
    }

    @Override
    public ProductTo saveProduct(ProductTo product) {

        ProductEntity productEntitiy = ProductMapper.map(product);
        productRepository.save(productEntitiy);
        return product;

    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);

    }
}
