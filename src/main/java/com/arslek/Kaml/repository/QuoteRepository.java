package com.arslek.Kaml.repository;

import com.arslek.Kaml.Entity.QuoteEntity;
import com.arslek.Kaml.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuoteRepository extends JpaRepository<QuoteEntity, Long> {

//    @Query(value = "select new QuoteEntity(q.id, q.content, q.createDate, q.updateDate, q.userId, q.votes) from QuoteEntity q order by q.votes")
//    @Query(value = "select * from quote q order by q.votes desc limit :count", nativeQuery = true)
//    List<QuoteEntity> findTop(@Param("count") Long count);
}
