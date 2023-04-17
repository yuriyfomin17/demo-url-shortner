CREATE TABLE shortened_urls
(
    id           VARCHAR,
    original_url VARCHAR(255) NOT NULL,
    title        VARCHAR(255),
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
