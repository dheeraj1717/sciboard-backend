package com.scient.labs.sciboard.repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.scient.labs.sciboard.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {
	
	public Optional<User> findByEmail(String email);
	
	public Optional<User> findByUsername(String username);

}