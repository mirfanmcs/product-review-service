package com.irfanstore.productReview.dto;

import lombok.Data;
import java.io.Serializable;

@Data
public class ProductReviewDto implements Serializable {

    public ProductReviewDto() {

    }

    private String id;
    private String productCode;
    private String reviewerFirstName;
    private String reviewerLastName;
    private String starRating;
    private String comments;

    @Override
    public String toString() {
        return "productReview {" +
                "id=" + id +
                ", productCode='" + productCode + '\'' +
                ", reviewerFirstName='" + reviewerFirstName + '\'' +
                ", reviewerLastName='" + reviewerLastName + '\'' +
                ", starRating='" + starRating + '\'' +
                ", comments=" + comments +
                '}';
    }
}
