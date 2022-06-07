package com.bcrypt.bcrypt.model;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String text;

    private Date date;

    @ManyToOne
    SiteUser postsOfUser;

    public Posts(){}
    public Posts(String text){
        this.text = text;
        this.date = new Date();
    }

    public long getId() {
        return id;
    }

    public SiteUser getPostsOfUser() {
        return postsOfUser;
    }

    public String getText() {
        return text;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPostsOfUser(SiteUser postsOfUser) {
        this.postsOfUser = postsOfUser;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
