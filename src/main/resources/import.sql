
INSERT INTO ROLE (name) VALUES ("SCOPE_ROLE_ADMIN");
INSERT INTO ROLE (name) VALUES ("SCOPE_ROLE_USER");

INSERT INTO USER (username,password,nombre,apellido,telefono,sexo,pais,fecha_alta,role_id,actived) VALUES ("admin","$2a$10$fn5BB.BgRINLPzP/RiD2K.6FtWwLxXqks0qGwwE13VwOZkmhiEKRq","pedro","cardoso","12345678","M","ARGENTINA",now(),1 ,true);
INSERT INTO USER (username,password,nombre,apellido,telefono,sexo,pais,fecha_alta,role_id,actived) VALUES ("user1","$2a$10$fn5BB.BgRINLPzP/RiD2K.6FtWwLxXqks0qGwwE13VwOZkmhiEKRq","pedro","cardoso","12345678","M","ARGENTINA",now(),2,true);
INSERT INTO USER (username,password,nombre,apellido,telefono,sexo,pais,fecha_alta,role_id,actived) VALUES ("user2","$2a$10$fn5BB.BgRINLPzP/RiD2K.6FtWwLxXqks0qGwwE13VwOZkmhiEKRq","pedro","cardoso","12345678","M","ARGENTINA",now(),2,true);