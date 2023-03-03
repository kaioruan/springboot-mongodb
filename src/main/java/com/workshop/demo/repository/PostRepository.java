package com.workshop.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.workshop.demo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
