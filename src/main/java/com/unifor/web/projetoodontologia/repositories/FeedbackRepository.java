package com.unifor.web.projetoodontologia.repositories;

import com.unifor.web.projetoodontologia.entities.Feedback;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends MongoRepository<Feedback, String> {
}
