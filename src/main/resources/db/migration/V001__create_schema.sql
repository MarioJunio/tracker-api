create table launch(
	id bigint not null primary key auto_increment,
	type varchar(60) not null,
	unit_type varchar(60) not null,
	value integer not null
); 

create table track(
	id bigint not null primary key auto_increment,
	speed integer not null,
	distance decimal(10,2) not null,
	accuracy decimal (10,2) not null,
	timer integer not null,
	launch_id bigint not null,
	version integer,
	foreign key (launch_id) references launch(id)
);

create table coordinate (
	id bigint not null primary key auto_increment,
	latitude decimal(10,7) not null,
	longitude decimal(10,7) not null,
	track_id bigint,
	foreign key (track_id) references track(id)
);