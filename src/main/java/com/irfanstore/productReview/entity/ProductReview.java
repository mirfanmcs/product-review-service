package com.irfanstore.productReview.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
public class ProductReview implements Serializable {

    @Id
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
