package com.bcrypt.bcrypt.controller;

import com.bcrypt.bcrypt.model.Posts;
import com.bcrypt.bcrypt.model.SiteUser;
import com.bcrypt.bcrypt.repository.PostsRepository;
import com.bcrypt.bcrypt.repository.SiteUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Controller
public class HomeController
{
    HomeController(){}
    @Autowired
    SiteUserRepository siteUserRepository;
    @Autowired
    PostsRepository postsRepository;

    @GetMapping("/home/{username}")
    public String getHome(@PathVariable String username, Model mdl)
    {
        SiteUser siteUserToView = siteUserRepository.findByUsername(username);

//        DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
//        LocalDateTime now = LocalDateTime.now();
//
//        String postDate = date.format(now);

        mdl.addAttribute("username", username.toLowerCase());
        mdl.addAttribute("siteUser", siteUserToView);
        mdl.addAttribute("posts", siteUserToView.getPostsList());




        return "home.html";
    }

    @PostMapping("/add-post")
    public RedirectView addPost(long siteUserId, String text)
    {
        SiteUser postsOfUser = siteUserRepository.getReferenceById(siteUserId);
        Posts postsToAdd = new Posts(text);
        postsToAdd.setPostsOfUser(postsOfUser);
        postsRepository.save(postsToAdd);
        String username = postsOfUser.getUsername();



        return new RedirectView("/home/" + username );
    }

}
