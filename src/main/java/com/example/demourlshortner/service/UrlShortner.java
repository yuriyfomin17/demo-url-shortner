package com.example.demourlshortner.service;

import com.example.demourlshortner.dto.LongUrl;
import com.example.demourlshortner.model.ShortUrl;
import com.example.demourlshortner.repo.UrlShortnerRepo;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UrlShortner {
    private final UrlShortnerRepo urlShortnerRepo;
    @Value("${url.length}")
    private int URL_LENGTH;

    @Transactional
    public ShortUrl createShortUrl(LongUrl longUrl) {
        var newUrl = new ShortUrl();
        newUrl.setId(getId());
        newUrl.setTitle(longUrl.title());
        newUrl.setOriginalUrl(longUrl.url());
        return urlShortnerRepo.save(newUrl);
    }

    private String getId(){
        return RandomStringUtils.randomAlphabetic(URL_LENGTH);
    }

    public ShortUrl findById(String id) {
        return urlShortnerRepo.findById(id).orElseThrow(() -> new RuntimeException("this id does not exist"));
    }
}
