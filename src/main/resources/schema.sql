CREATE TABLE IF NOT EXISTS lesnoydb.open_book.author
(
    id        SERIAL PRIMARY KEY,
    full_name VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS lesnoydb.open_book.book
(
    id            SERIAL PRIMARY KEY,
    thumbnail_url VARCHAR(255) NOT NULL,
    book_name     VARCHAR(40)  NOT NULL,
    author_id     INT REFERENCES lesnoydb.open_book.author (id),
    pageCount     INT          NOT NULL,
    subtitle      VARCHAR(255),
    description   TEXT
);

CREATE TABLE IF NOT EXISTS lesnoydb.open_book.user
(
    id       SERIAL PRIMARY KEY,
    username VARCHAR(30),
    password VARCHAR(255) NOT NULL,
    email    VARCHAR(255) UNIQUE
);

CREATE TABLE IF NOT EXISTS lesnoydb.open_book.feedback
(
    user_id INT REFERENCES lesnoydb.open_book.user (id),
    book_id INT REFERENCES lesnoydb.open_book.book (id),
    review  TEXT,
    rating  REAL
);

CREATE TABLE IF NOT EXISTS lesnoydb.open_book.history
(
    user_id  INT REFERENCES lesnoydb.open_book.user (id),
    book_id  INT REFERENCES lesnoydb.open_book.book (id),
    date_issue TIMESTAMP NOT NULL,
    date_return  TIMESTAMP
);

