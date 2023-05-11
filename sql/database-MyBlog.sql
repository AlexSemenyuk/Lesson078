DROP DATABASE myBlog;
create database myBlog default char set utf8;
use myBlog;

CREATE TABLE `users`
(
    `id`           INT PRIMARY KEY NOT NULL    AUTO_INCREMENT,
    `first_name`   VARCHAR(255)    NOT NULL,
    `last_name`    VARCHAR(255)    NOT NULL,
    `login`        VARCHAR(255)    NOT NULL    unique,
    `password`     VARCHAR(255)    NOT NULL    unique
);
