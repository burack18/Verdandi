package com.example.verdandibackend.model;

import com.example.verdandibackend.model.basemodel.DbModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event extends DbModel {

    @Column(name = "content")
    private String content;

    @Column(name = "create_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @Column(name = "like_count")
    private Long likeCount;

    @Column(name = "dislike_count")
    private Long dislikeCount;

    @ManyToOne
    private ApplicationUser createrUser;

    @OneToMany(mappedBy ="event")
    private List<Comment> comments;

}
