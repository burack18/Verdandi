package com.example.verdandibackend.model;

import com.example.verdandibackend.model.basemodel.DbModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role extends DbModel {
    @Column(name = "name")
    private String name;
}