package com.example.demourlshortner.service;

import com.example.demourlshortner.dto.LongUrl;
import com.example.demourlshortner.model.ShortUrl;
import com.example.demourlshortner.repo.UrlShortnerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UrlShortner {
    private final UrlShortnerRepo urlShortnerRepo;

    @Transactional
    public ShortUrl createShortUrl(LongUrl longUrl){
        var newUrl = new ShortUrl();
        newUrl.setId(getId());
        newUrl.setTitle(longUrl.title());
        newUrl.setOriginalUrl(longUrl.url());
        return urlShortnerRepo.save(newUrl);
    }
    public ShortUrl findById(String id){
        return urlShortnerRepo.findById(id).orElseThrow(() -> new RuntimeException("this id does not exist"));
    }

    private String getId(){
        return UUID.randomUUID().toString();
    }
}
