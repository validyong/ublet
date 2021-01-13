--system
CREATE USER SJO03 IDENTIFIED BY system123;
GRANT ALL PRIVILEGES TO SJO03;

--sjo03

-- sjo03.user_info
  CREATE TABLE user_info (
    user_id VARCHAR2(20) PRIMARY KEY,
    password VARCHAR2(20) NOT NULL,
    mail_address VARCHAR2(20) NOT NULL
  ) ;

-- sjo03.genre
CREATE TABLE genre (
  genre_code number(20) PRIMARY KEY,
  genre_name VARCHAR2(20) NOT NULL
);

-- sjo03.book
CREATE TABLE book (
  isbn VARCHAR2(20) PRIMARY KEY,
  book_name VARCHAR2(20) NOT NULL,
  company VARCHAR2(20),
  price number(20),
  genre_code REFERENCES genre(genre_code)
);

--view
create view view_outer_book_genre as
select
book.isbn,
book.book_name,
book.company,
book.price,
book.genre_code,
genre.genre_name
from book
left outer join genre
on book.genre_code = genre.genre_code;
