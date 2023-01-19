package com.severina.BlogApp.Configuration;

import com.severina.BlogApp.account.Dto.AccountRegistrationDto;
import com.severina.BlogApp.account.Dto.AccountRepository;
import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountService {
    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public AccountService(AccountRepository accountRepository, ModelMapper modelMapper) {
        this.accountRepository = accountRepository;
        this.modelMapper = modelMapper;
    }

    public User registerUser(AccountRegistrationDto accountRegistrationDto) {
        User userToSave = modelMapper.map(accountRegistrationDto, User.class);
/*        User savedUser = userRepository.save(userToSave);*/
        return modelMapper.map(userToSave, User.class);
    }
}