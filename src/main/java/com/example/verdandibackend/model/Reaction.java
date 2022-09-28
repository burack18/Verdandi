package com.example.verdandibackend.model;

import com.example.verdandibackend.model.basemodel.DbModel;
import com.example.verdandibackend.model.enums.ReactionType;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Reaction extends DbModel {
        @Column(name = "reaction_type")
        @Enumerated(EnumType.STRING)
        private ReactionType reactionType;

        @ManyToOne
        @JoinColumn(name = "event_id")
        private Event event;

        @ManyToOne
        @JoinColumn(name = "comment_id")
        private Comment comment;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private ApplicationUser user;
}
