package com.irfanstore.productReview.repository;

import com.irfanstore.productReview.entity.ProductReview;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductReviewRepository extends MongoRepository<ProductReview, String> {
    ProductReview findByProductCode(String productCode);
}
