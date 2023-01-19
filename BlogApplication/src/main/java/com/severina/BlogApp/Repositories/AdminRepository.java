package com.severina.BlogApp.Repositories;

import com.severina.BlogApp.Entity.Admin;
import com.severina.BlogApp.Entity.Accounts;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends MongoRepository<Admin, Long> {

    Optional<Accounts> findOneByEmailIgnoreCase(String email);

}
