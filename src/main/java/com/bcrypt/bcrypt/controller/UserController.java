package com.bcrypt.bcrypt.controller;

import com.bcrypt.bcrypt.model.SiteUser;
import com.bcrypt.bcrypt.repository.SiteUserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.persistence.GeneratedValue;

@Controller
public class UserController
{
    @Autowired
    SiteUserRepository siteUserRepository;

    @GetMapping("/")
    public String getLoginPage()
    {
        return "index.html";
    }

    @GetMapping("/signup")
    public String getSignUpPage(){
        return "signup.html";
    }

    @PostMapping("/signup")
    public RedirectView signup(String username, String password)
    {
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        SiteUser newSiteUser = new SiteUser(username, hashedPassword);
        siteUserRepository.save(newSiteUser);
        return new RedirectView("/");
    }

    @PostMapping("/login")
    public RedirectView login(String username, String password)
    {
        SiteUser userFromDB = siteUserRepository.findByUsername(username);
        if (userFromDB == null)
        {
            return new RedirectView("/");
        }

        boolean isPasswordCorrect = BCrypt.checkpw(password, userFromDB.getPassword());

        if (!isPasswordCorrect)
        {
            return new RedirectView("/");
        }
        else
        {
            return new RedirectView("/home/" + username);
        }
    }



}
