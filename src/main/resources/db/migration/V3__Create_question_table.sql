create table question
(
	id int auto_increment,
	title varchar2(50),
	description TEXT,
	gmt_create bigint,
	gmt_modified bigint,
	creator int,
	comment_count int default 0,
	view_count int default 0,
	like_count int default 0,
	tag varchar2(256),
	constraint question_pk primary key (id)
);

