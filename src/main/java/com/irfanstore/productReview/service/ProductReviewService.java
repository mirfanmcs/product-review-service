package com.irfanstore.productReview.service;

import com.irfanstore.productReview.dto.ProductReviewDto;
import com.irfanstore.productReview.entity.ProductReview;
import com.irfanstore.productReview.repository.ProductReviewRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class ProductReviewService {
    @Autowired
    private ProductReviewRepository productReviewRepository;


    //TODO -> Add the bean of this and use @Autowired
    private ModelMapper modelMapper= new ModelMapper();

    public List<ProductReviewDto> getProductReviews() {

        List<ProductReview> productReviews = productReviewRepository.findAll();
        Type listType = new TypeToken<List<ProductReviewDto>>() {}.getType();
        List<ProductReviewDto> productReviewDtoList = modelMapper.map(productReviews, listType);
        return productReviewDtoList;
    }

    public ProductReviewDto getProductReview(String id) {
        ProductReview productReview =  productReviewRepository.findOne(id);
        ProductReviewDto productReviewDto =  modelMapper.map(productReview, ProductReviewDto.class);
        return productReviewDto;
    }

   public ProductReviewDto getProductReviewByProductCode(String productCode) {
       ProductReview productReview = productReviewRepository.findByProductCode(productCode);
       ProductReviewDto productReviewDto =  modelMapper.map(productReview, ProductReviewDto.class);
       return productReviewDto;

    }

    public ProductReviewDto createOrUpdateProductReview(ProductReviewDto productReviewDto) {
        ProductReview productReview =  modelMapper.map(productReviewDto, ProductReview.class);
        ProductReview productReviewCreated =  productReviewRepository.save(productReview);
        ProductReviewDto productReviewDtoCreated =  modelMapper.map(productReviewCreated, ProductReviewDto.class);
        return productReviewDtoCreated;
    }

    public void deleteProductReview(String id) {
        productReviewRepository.delete(id);

    }
}
