create table Estante(
  BookId int,
  BookName varchar(100),
  BookEdition int,
  BookPrice number(10,2),
  BookPublisher varchar(30),
  BookAuthor varchar(50),
  BookTotalPages int,
  BookCurrentPages int
  
);

select * from Estante;

create sequence idBook

increment by 1

start with 1

maxvalue 9999

nocycle;

