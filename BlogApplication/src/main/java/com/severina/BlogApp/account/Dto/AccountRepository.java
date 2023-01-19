package com.severina.BlogApp.account.Dto;

import com.severina.BlogApp.Entity.Accounts;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.awt.print.Pageable;

public interface AccountRepository extends MongoRepository<Accounts, Long> {

    Page<Accounts> findByUserId(Long id, Pageable pageable);


}
