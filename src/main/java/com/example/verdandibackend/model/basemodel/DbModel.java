package com.example.verdandibackend.model.basemodel;

import javax.persistence.*;

@MappedSuperclass
public class DbModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}
