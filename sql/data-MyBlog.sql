use myBlog;
insert into users (first_name, last_name, login, password)
VALUES ('Oleg', 'Luchenko', 'admin', 'admin'),
       ('Vitek', 'Verepianko', 'vitek', '123'),
       ('Anna', 'Yaschenko', 'anna', '321');

select * from users where login='admin' and password='admin';
SELECT * FROM users WHERE login = 'admin' and password = 'admin';

insert into users (first_name, last_name, login, password)
VALUES ('Vitek', 'Konovalov', 'vitek', '531');




