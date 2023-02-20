package com.arslek.Kaml.repository;

import com.arslek.Kaml.Entity.QuoteEntity;
import com.arslek.Kaml.Entity.UserEntity;
import com.arslek.Kaml.Entity.VoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository extends JpaRepository<VoteEntity, Long> {

    @Query(value = "select * from vote v where v.quote_id = :id", nativeQuery = true)
    List<VoteEntity> findByQuoteId(@Param("id") Long id);
}
