package com.example.demourlshortner.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@RedisHash("ShortenedUrl")
public class ShortUrl {

    @Id
    private String id;

    private String originalUrl;

    private String title;

    private LocalDateTime createdAt = LocalDateTime.now();

}