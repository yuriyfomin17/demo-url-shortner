package com.example.demourlshortner.repo;

import com.example.demourlshortner.model.ShortUrl;
import org.springframework.data.repository.CrudRepository;

public interface UrlShortnerRepo extends CrudRepository<ShortUrl, String> {
}
