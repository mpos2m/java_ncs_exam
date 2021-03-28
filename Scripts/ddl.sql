create database ncs_exam;

show databases;
use ncs_exam;
show tables;


create table title (
	tno int not null primary key,
	tname varchar(20) not null);
	
select * from title;