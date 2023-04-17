package com.example.demourlshortner.controller;

import com.example.demourlshortner.dto.LongUrl;
import com.example.demourlshortner.model.ShortUrl;
import com.example.demourlshortner.service.UrlShortner;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/shortner")
@RequiredArgsConstructor
public class UrlController {
    private final UrlShortner urlShortner;

    @PostMapping
    public ResponseEntity<?> shortenUrl(@RequestBody LongUrl longUrl) {
        ShortUrl savedShortenUrl = urlShortner.createShortUrl(longUrl);
        HttpHeaders httpHeaders = new HttpHeaders();
        var shortenedUrl = URI.create(savedShortenUrl.getId());
        httpHeaders.setLocation(shortenedUrl);
        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        var url = urlShortner.findById(id).getOriginalUrl();
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(url));
        return new ResponseEntity<>(headers, HttpStatus.PERMANENT_REDIRECT);
    }


}
