package com.example.demourlshortner.repo;

import com.example.demourlshortner.model.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlShortnerRepo extends JpaRepository<ShortUrl, String> {
}
