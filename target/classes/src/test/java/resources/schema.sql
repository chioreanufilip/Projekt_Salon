create table Barber(ID int primary key, name varchar(100),hairStyle varchar(max),Experience int,Specialisation varchar(150));

create table Pedicurist(ID int primary key,name varchar(100),experience int,speciality varchar(150),FootCareSpecialisation varchar(150));

create table NailPainter(ID int primary key,name varchar(100),experience int,speciality varchar(150),gelNailExperience varchar(150));
create table Product(ID int primary key,Name varchar(100),Price float,Stock int,Type int);
create table Client (ID int primary key, Name varchar(100),PhoneNumber varchar(20));
create table Review(ID int primary key,Rating int,comment varchar(max),ClientID int, foreign key (ClientID) references Client(ID));
create table Service(ID int primary key, Name varchar(30),Duration varchar(50),Price float);
create table Service_Employees(ID int primary key identity(1,1),ID_Service int,ID_Barber int,ID_Pedicurist int,ID_NailPainter int, foreign key (ID_Service) references Service(ID),foreign key (ID_Barber)
    references Barber(ID),foreign key (ID_Pedicurist) references Pedicurist(ID),foreign key (ID_NailPainter) references NailPainter(ID));
alter table Service_Employees add constraint unic unique (ID_Service,ID_Barber,ID_Pedicurist,ID_NailPainter);
create table Payments (ID int primary key identity(1,1),ID_Payment int ,ClientID int,ID_Services int,ID_Products int,foreign key (ClientID) references Client(ID), foreign key (ID_Products) references Product(ID),
                       foreign key (ID_Services) references Service(ID));
alter table Payments add constraint unic1 unique (ID_Payment,ClientID,ID_Services,ID_Products);
create table Appointment(ID int primary key identity(1,1),ID_Appointment int,dateTime varchar(50),ClientId int,ServiceID int,PaymentID int,
                         foreign key (ClientID) references Client(ID),foreign key (ServiceID) references Service(ID));
alter table Appointment add constraint unic2 unique (ID_Appointment,dateTime,ClientId,ServiceID,PaymentID);