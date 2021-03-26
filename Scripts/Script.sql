grant all on ncs_exam.* to 'exam'@'localhost' identified by '123123';

grant file on *.* to 'exam'@'localhost';

select * from title;
insert into title values (6, '인턴');
delete from title where tno=6;