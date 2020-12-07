create table Student
	(StudentId int PRIMARY KEY, 
	StudentName varchar(12), 
	StudentContact varchar(12));

create table Book(
	SerialNum varchar(12) PRIMARY KEY,
	Title varchar(12) not null,
	Author varchar(12) not null, 
	Publisher varchar(12) not null, 
	Quantity int, 
	IssuedQuant int, 
	AddedDate varchar(12);
	
create table IssuedBooks
	(ID int PRIMARY KEY, 
	SerialNum varchar(12), 
	StudentId int, 
	StudentName varchar(12), 
	StudentContact varchar(12), 
	IssueDate varchar(12), 
	CONSTRAINT Serial_Num_FK FOREIGN KEY (SerialNum) REFERENCES Book (SerialNum),
	CONSTRAINT Student_Num_FK FOREIGN KEY (StudentId) REFERENCES Student (StudentId);
	
CREATE TABLE IssuedBooks (
ID int PRIMARY KEY,
SerialNum text,
StudentName text,
StudentContact text,
IssueDate Date,
StudentId int, 
foreign key (SerialNum) references Book (SerialNum),
foreign key (StudentId) references Student (StudentId));