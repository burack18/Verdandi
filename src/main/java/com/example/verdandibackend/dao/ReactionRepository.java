package com.example.verdandibackend.dao;

import com.example.verdandibackend.model.Reaction;
import com.example.verdandibackend.model.enums.ReactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReactionRepository extends JpaRepository<Reaction,Integer> {
    @Query("SELECT COUNT(a) FROM Reaction a where a.event.id=:eventId and a.reactionType=:type")
    Integer getAllByEvent_IdAndReactionType(Integer eventId, ReactionType type);


}
