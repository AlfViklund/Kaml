package com.arslek.Kaml.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@Entity
@Table(name = "QUOTE")
public class QuoteEntity extends AbstractEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="quote_id_seq")
    @SequenceGenerator(name="quote_id_seq", sequenceName="quote_id_seq", allocationSize=1)
    private Long id;

    @Column(name="content")
    private String content;

    @CreatedDate
    @Column(name="create_date")
    private Date createDate;

    @LastModifiedDate
    @Column(name="update_date")
    private Date updateDate;

    @Column(name="user_id")
    private Long userId;

    @OneToMany(mappedBy = "quoteId", orphanRemoval = true, cascade = CascadeType.REMOVE)
    private List<VoteEntity> votes;

}
