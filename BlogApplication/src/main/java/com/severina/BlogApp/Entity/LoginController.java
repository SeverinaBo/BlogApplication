package com.severina.BlogApp.Entity;

import com.severina.BlogApp.Configuration.AccountService;
import com.severina.BlogApp.account.Dto.AccountRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

public class LoginController {
    private AccountService accountService;

    @Autowired
    public void UserController(AccountService accountService) {
        this.accountService = accountService;
    }

    public LoginController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/register")
    public String getRegisterView(Model model) {
        model.addAttribute("userToRegister", new AccountRegistrationDto());
        return "users/register";    //Leads to HTML document
    }

    @PostMapping("/register")
    public String registerNewUser(@ModelAttribute("userToRegister") @Valid AccountRegistrationDto userToRegister, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()){
            return "users/register";
        };
        AccountRegistrationDto registeredUser = (AccountRegistrationDto) accountService.registerUser(userToRegister);

        redirectAttributes.addFlashAttribute("registeredUser", registeredUser);
        return "redirect:/users/register";  //Redirects to URL (not HTML document, but an endpoint)
    }

}
