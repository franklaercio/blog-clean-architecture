package com.github.blog.entities;

import com.github.blog.entities.enums.Status;
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
@Table(name = "posts")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String author;

    private String title;

    private String subtitle;

    private String content;

    @Column(name = "allow_comment")
    private Boolean allowComment;

    @Column(name = "allow_ping")
    private Boolean allowPing;

    @Column(name = "allow_feed")
    private Boolean allowFeed;

    private String url;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @Timestamp
    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Timestamp
    @CreatedDate
    @Column(name = "update_at")
    private LocalDateTime updateAt;
}
