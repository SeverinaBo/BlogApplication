package com.severina.BlogApp.controller;

import com.severina.BlogApp.Configuration.AccountService;
import com.severina.BlogApp.Entity.Accounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistrationController {

    @Autowired
    public AccountService accountService;

    @GetMapping("/register")
    public String getRegistrationForm(Model model){
        Accounts accounts = new Accounts();
        model.addAttribute("account", accounts);
        return "registration_page";
    }

/*
    @PostMapping("/register")
    public String registerNewUser(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/";
    }
*/

/*
    private final UserService userService;

    @GetMapping("/register") {
        public String getRegisterView (Model model){
            model.addAttribute("userToRegister", new UserRegistrationDto());
            return "users/register";    //Leads to HTML document
        }

        @PostMapping("/register")
        public String registerNewUser(@ModelAttribute("userToRegister") @Valid UserRegistrationDto userToRegister, BindingResult
        bindingResult, RedirectAttributes redirectAttributes) {
            if(bindingResult.hasErrors()){
                return "users/register";
            };
            UserDto registeredUser = userService.registerUser(userToRegister);

            redirectAttributes.addFlashAttribute("registeredUser", registeredUser);
            return "redirect:/users/register";  //Redirects to URL (not HTML document, but an endpoint)
        }
    */
}
