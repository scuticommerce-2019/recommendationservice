package com.scuticommerce.recommendationservice.service;

import com.scuticommerce.model.product.Product;
import com.scuticommerce.model.recommend.Recommendation;
import com.scuticommerce.recommendationservice.repository.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationService {

    @Autowired
    RecommendationRepository recommendationRepository;

    public void createRecommendations(List<Product> productList, String zone){

        Recommendation recommendation = new Recommendation();
        recommendation.setItems(productList);
        recommendation.setZone(zone);

        recommendationRepository.save(recommendation);

    }

    public Recommendation getRecommendations(String zone){
        return recommendationRepository.findByZone(zone);
    }
}
