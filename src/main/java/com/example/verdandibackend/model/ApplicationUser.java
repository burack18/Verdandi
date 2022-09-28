package com.example.verdandibackend.model;

import com.example.verdandibackend.model.basemodel.DbModel;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApplicationUser extends DbModel {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "birth_date")
    private String birthDate;

    @Column(name = "user_score")
    private Long userScore;

    @NotNull
    @Column(name = "password")
    private String password;


    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles=new ArrayList();
}
