create database eventplanner;
use eventplanner;
create table Admin(
	username varchar(20) primary key,
    firstname varchar(20) not null,
    lastname varchar(20) not null,
    passwd varchar(20) not null,
    email varchar(50) not null,
    mobile varchar(10) not null
);

create table Vendor(
	vendorid int primary key,
    username varchar(20) unique,
    passwd varchar(20) not null,
	firstname varchar(20) not null,
    lastname varchar(20) not null,
    street varchar(20),
    city varchar(20),
    state varchar(20),
    country varchar(20),
    pincode varchar(6),
	email varchar(50) not null,
    mobile varchar(10) not null
);

create table User(
	userid int primary key,
    firstname varchar(20) not null,
    lastname varchar(20) not null,
    username varchar(20) unique,
	passwd varchar(20) not null,
    doj date,
    dob date,
    dept varchar(20) check (dept in ('Marketing','Sales','IT')),
    email varchar(50) not null,
    mobile varchar(10) not null,
    location varchar(20),
    userstatus varchar(15) check (status in ('active','non-active')) default 'non-active'
);


create table Planrequest(
	requestid int primary key,
    fromdate date,
    todate date,
    nopeopleattending int,
    userid int,
    -- listofservices varchar(500) ,
	foreign key(userid) references User(userid)
);

create table Quotation(
	quotid int primary key,
    packagetype varchar(20) check (packagetype in ('Basic','Premium','Classic')),
    estimatedamt double,
    vendorid int,
    userid int,
    requestid int,
    quotstatus varchar(10) check (quotstatus in ('Accepted','Pending','Rejected')) default 'pending',
    foreign key(vendorid) references Vendor(vendorid),
    foreign key(userid) references User(userid),
    foreign key(requestid) references Planrequest(requestid)
);

create table Package(
	packageid int primary key,
    packagetype varchar(20) check (packagetype in ('Basic','Premium','Classic')),
	-- list of services
    amount double not null,
    vendorid int,
    foreign key(vendorid) references Vendor(vendorid)
);