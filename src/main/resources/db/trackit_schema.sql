drop database if exists trackit;
create database trackit;

use trackit;

grant usage on *.* to trackituser@localhost identified by 'trackit123';
grant all privileges on trackit.* to trackituser@localhost;

create table user (
	id int(11) unsigned primary key auto_increment,
    username varchar(128) unique not null,
    password varchar(32) default null
);

create table group_account (
	id int(11) unsigned primary key auto_increment,
    name varchar(128) not null
);

create table group_account_user (
	group_account_id int(11) unsigned not null,
    user_id int(11) unsigned not null,
    primary key (group_account_id, user_id),
    foreign key (group_account_id)
		references group_account (id)
        on delete cascade,
	foreign key (user_id)
		references user (id)
        on delete cascade
);

create table purchase (
	id int(11) unsigned primary key auto_increment,
    title varchar(128) not null,
    purchase_date date,
    state int(1) unsigned default 0,
    user_id int(11) unsigned not null,
    foreign key (user_id)
		references user (id)
);

create table item (
	id int(11) unsigned primary key auto_increment,
    label varchar(128) not null,
    price int(8) unsigned not null,
    purchase_id int(11) unsigned,
    foreign key (purchase_id)
		references purchase (id)
        on delete cascade
);

create table share (
	share tinyint(1) unsigned not null,
    item_id int(11) unsigned not null,
    user_id int(11) unsigned not null,
    primary key (item_id, user_id),
    foreign key (item_id)
		references item (id)
        on delete cascade,
	foreign key (user_id)
		references user (id)
);