package com.arslek.Kaml.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "vote")
public class VoteEntity extends AbstractEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="vote_id_seq")
    @SequenceGenerator(name="vote_id_seq", sequenceName="vote_id_seq", allocationSize=1)
    private Long id;

    @Column(name="user_id")
    private Long userId;

    @Column(name="quote_id")
    private Long quoteId;

    @CreatedDate
    @Column(name="create_date")
    private Date createDate;

    @LastModifiedDate
    @Column(name="update_date")
    private Date updateDate;
}
