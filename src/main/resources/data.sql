DROP TABLE IF EXISTS book_authors;
DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS authors;

CREATE TABLE authors (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    deleted_at TIMESTAMP
);

CREATE TABLE books (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    deleted_at TIMESTAMP
);

CREATE TABLE book_authors (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    book_id BIGINT NOT NULL,
    author_id BIGINT NOT NULL,
    FOREIGN KEY (book_id) REFERENCES books(id),
    FOREIGN KEY (author_id) REFERENCES authors(id),
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    deleted_at TIMESTAMP
);

INSERT IGNORE INTO authors ( name, email, phone) VALUES ( 'J.K. Rowling', 'jkrowling@example.com', '123-456-7890');
INSERT IGNORE INTO authors ( name, email, phone) VALUES ( 'George R.R. Martin', 'grrmartin@example.com', '234-567-8901');
INSERT IGNORE INTO authors ( name, email, phone) VALUES ( 'J.R.R. Tolkien', 'jrrtolkien@example.com', '345-678-9012');
INSERT IGNORE INTO authors ( name, email, phone) VALUES ( 'Stephen King', 'stephenking@example.com', '456-789-0123');

INSERT IGNORE INTO books ( title) VALUES ( 'Harry Potter');
INSERT IGNORE INTO books ( title) VALUES ( 'Game of Thrones');
INSERT IGNORE INTO books ( title) VALUES ( 'Lord of the Rings');
INSERT IGNORE INTO books ( title) VALUES ( 'The Shining');

INSERT IGNORE INTO book_authors ( book_id, author_id) VALUES ( 1, 1);
INSERT IGNORE INTO book_authors ( book_id, author_id) VALUES ( 1, 2);
INSERT IGNORE INTO book_authors ( book_id, author_id) VALUES ( 2, 2);
INSERT IGNORE INTO book_authors ( book_id, author_id) VALUES ( 2, 3);
INSERT IGNORE INTO book_authors ( book_id, author_id) VALUES ( 3, 3);
INSERT IGNORE INTO book_authors ( book_id, author_id) VALUES ( 3, 4);
INSERT IGNORE INTO book_authors ( book_id, author_id) VALUES ( 4, 4);
