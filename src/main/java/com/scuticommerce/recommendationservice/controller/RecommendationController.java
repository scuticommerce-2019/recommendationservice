package com.scuticommerce.recommendationservice.controller;

import com.scuticommerce.model.product.Product;
import com.scuticommerce.recommendationservice.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value="/api/recomendationservice/")
public class RecommendationController {

    @Autowired
    RecommendationService recommendationService;

    @GetMapping(value="/status")
    public ResponseEntity<?> up(){

        return new ResponseEntity<>( HttpStatus.OK);
    }

    @GetMapping(value="/recommend")
    public ResponseEntity<?> recommend(@RequestParam String zone){

        return new ResponseEntity<>(recommendationService.getRecommendations(zone), HttpStatus.OK);
    }

    @PostMapping(value="/create")
    public ResponseEntity<?> create(@RequestBody List<Product> productList, @RequestParam String zone){

        recommendationService.createRecommendations(productList, zone);

        return new ResponseEntity<>( HttpStatus.OK);
    }
}