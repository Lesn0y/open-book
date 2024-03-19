CREATE TABLE IF NOT EXISTS books
(
    id            SERIAL PRIMARY KEY,
    name          VARCHAR(126) NOT NULL,
    author        VARCHAR(126) NOT NULL,
    description   VARCHAR(126) NOT NULL,
    thumbnail_url TEXT,
    in_stock      BOOLEAN DEFAULT (true)
);
