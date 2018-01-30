package org.matecomp.sportlife.repository;

import org.matecomp.sportlife.collection.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findByUsername(final String userName);
}
