package com.scuticommerce.recommendationservice.repository;

import com.scuticommerce.model.recommend.Recommendation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecommendationRepository extends MongoRepository<Recommendation,String> {

    Recommendation findByZone(String zone);
}
