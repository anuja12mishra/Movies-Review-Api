package dev.anuj.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class ReviewService {

    private final ReviewRepository repository;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public ReviewService(ReviewRepository repository, MongoTemplate mongoTemplate) {
        this.repository = repository;
        this.mongoTemplate = mongoTemplate;
    }

    public Review createReview(String reviewBody, String imdbId) {
        try {
            // Create a new Review with generated ObjectId
            Review review = new Review();
            review.setId(new org.bson.types.ObjectId());
            review.setReviewBody(reviewBody);
            review.setCreatedAt(LocalDateTime.now());
            review.setUpdatedAt(LocalDateTime.now());

            // Save the review in MongoDB
            review = repository.save(review);

            // Update the Movie document with the new review ID
            mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds", review.getId()))
                .first();

            return review;
        } catch (Exception e) {
            throw new RuntimeException("Error creating review: " + e.getMessage(), e);
        }
    }
}
