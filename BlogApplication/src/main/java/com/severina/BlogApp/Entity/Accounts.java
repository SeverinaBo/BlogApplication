package com.severina.BlogApp.Entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

import javax.persistence.*;
import java.util.List;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class Accounts implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
   private Long password;

   @OneToMany(mappedBy = "accounts") //relationship between account and blogPosts. Each user can have its own set of poots
   private Page<BlogPost> blogPosts; //one-to-many mapping means that one row in a table is mapped to multiple rows in another table.

    public Accounts() {
    }


    public Accounts(Long userId, String firstName, String lastName, String email, Long password) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }







/*    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if(!(o instanceof User))
            return false;
        User user = (User) o;
        return Object.equals(this._id, this.firstName, this.email, this.text)
                && Object.equals(this.firstName, user.firstName)
                && Object.equals(this.email, user.email);* //add id, lastName, texts
    }*/

}

