package com.example.demourlshortner.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity
@Table(name = "short_urls")
public class ShortUrl {

    @Id
    private String id;

    @Column(nullable = false, name = "original_url", unique = true)
    private String originalUrl;

    @Column(nullable = false, name = "title")
    private String title;

    @Column(nullable = false, name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShortUrl note)) return false;
        return id != null && id.equals(note.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}