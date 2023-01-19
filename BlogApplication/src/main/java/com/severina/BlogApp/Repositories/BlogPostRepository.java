package com.severina.BlogApp.Repositories;

import com.severina.BlogApp.Entity.BlogPost;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface BlogPostRepository extends MongoRepository<BlogPost, Long> {

Page<BlogPost> findAllByTitle(String blogPostTitle, Pageable pageable);

Page<BlogPost> findAll(Pageable pageable);


}

