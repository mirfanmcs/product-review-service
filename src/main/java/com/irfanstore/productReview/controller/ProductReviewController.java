package com.irfanstore.productReview.controller;

import com.irfanstore.productReview.dto.ProductReviewDto;
import com.irfanstore.productReview.service.ProductReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class ProductReviewController {

    @Autowired
    private ProductReviewService productReviewService;

    @GetMapping(path="/api/productreview/{id}")
    public ResponseEntity<ProductReviewDto> getproductReview(@PathVariable String id) {
        return new ResponseEntity<ProductReviewDto>(productReviewService.getProductReview(id), HttpStatus.OK);
    }

    @GetMapping(path="/api/productreview")
    public ResponseEntity<List<ProductReviewDto>> getproductReviews() {
        return new ResponseEntity<List<ProductReviewDto>>(productReviewService.getProductReviews(), HttpStatus.OK);
    }

    @RequestMapping(value = "/api/productreview/productcode/{productCode}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductReviewDto> getByProducCode(@PathVariable String productCode) {
        return new ResponseEntity<ProductReviewDto>(productReviewService.getProductReviewByProductCode(productCode.toUpperCase()), HttpStatus.OK);
    }


    @RequestMapping(value = "/api/productreview",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductReviewDto> createproductReview(@Valid @RequestBody ProductReviewDto productReviewDto) throws URISyntaxException
    {

        System.out.println(String.format("REST request to save productReview: {%s}",  productReviewDto));
        if (productReviewDto.getId() != null) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        ProductReviewDto mewproductReview = productReviewService.createOrUpdateProductReview(productReviewDto);

        return ResponseEntity.created(new URI("/api/productreview/" + mewproductReview.getId()))
                .body(mewproductReview);
    }


    @RequestMapping(value = "/api/productreview",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductReviewDto> updateproductReview(@Valid @RequestBody ProductReviewDto productReviewDto) throws URISyntaxException
    {
        System.out.println(String.format("REST request to update productReview : {%s}", productReviewDto));
        if (productReviewDto.getId() == null)
        {
            return createproductReview(productReviewDto);
        }

        ProductReviewDto updatedproductReview = productReviewService.createOrUpdateProductReview(productReviewDto);
        return ResponseEntity.ok()
                .body(updatedproductReview);
    }

    @RequestMapping(value = "/api/productreview/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteproductReview(@PathVariable String id)
    {
        System.out.println(String.format("REST request to delete productReview : {%s}", id));
        productReviewService.deleteProductReview(id);
        return ResponseEntity.ok().build();
    }

}
