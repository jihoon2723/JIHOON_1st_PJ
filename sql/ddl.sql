create table user(
	id bigint not null auto_increment primary key,
    email varchar(255) not null unique,
    name varchar(200) not null,
    password varchar(200) not null,
    auth varchar(100)
);

select * from user ;