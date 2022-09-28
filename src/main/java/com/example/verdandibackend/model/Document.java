package com.example.verdandibackend.model;

import com.example.verdandibackend.model.basemodel.DbModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Entity
@Data
public class Document  extends DbModel {
    @Lob
    private byte[] profileFoto;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "user_id")
    private ApplicationUser user;
}
