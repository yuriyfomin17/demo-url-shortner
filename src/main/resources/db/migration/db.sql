CREATE TABLE IF NOT EXISTS shortened_urls
(
    id           TEXT PRIMARY KEY,
    original_url TEXT NOT NULL,
    title        TEXT NOT NULL,
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
