package com.github.blog.entities;

import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "comment")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "person_name")
    private String personName;

    @Column(name = "person_email")
    private String personEmail;

    private String content;

    @Timestamp
    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Timestamp
    @CreatedDate
    @Column(name = "update_at")
    private LocalDateTime updateAt;

}
