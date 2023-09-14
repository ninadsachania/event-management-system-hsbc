CREATE DATABASE eventplanner;
USE eventplanner;

CREATE TABLE Admin (
    username VARCHAR(20) PRIMARY KEY,
    firstname VARCHAR(20) NOT NULL,
    lastname VARCHAR(20) NOT NULL,
    passwd VARCHAR(20) NOT NULL,
    email VARCHAR(50) NOT NULL,
    mobile VARCHAR(10) NOT NULL
);

CREATE TABLE Vendor (
    vendorid INT PRIMARY KEY,
    username VARCHAR(20) UNIQUE,
    passwd VARCHAR(20) NOT NULL,
    firstname VARCHAR(20) NOT NULL,
    lastname VARCHAR(20) NOT NULL,
    street VARCHAR(20),
    city VARCHAR(20),
    state VARCHAR(20),
    country VARCHAR(20),
    pincode VARCHAR(6),
    email VARCHAR(50) NOT NULL,
    mobile VARCHAR(10) NOT NULL
);

CREATE TABLE User (
    userid INT PRIMARY KEY,
    firstname VARCHAR(20) NOT NULL,
    lastname VARCHAR(20) NOT NULL,
    username VARCHAR(20) UNIQUE,
    passwd VARCHAR(20) NOT NULL,
    doj DATE,
    dob DATE,
    dept VARCHAR(20) CHECK (dept IN ('Marketing', 'Sales', 'IT')),
    email VARCHAR(50) NOT NULL,
    mobile VARCHAR(10) NOT NULL,
    location VARCHAR(20),
    userstatus VARCHAR(15) CHECK (userstatus IN ('active', 'non-active')) DEFAULT 'non-active'
);

CREATE TABLE Planrequest (
    requestid INT PRIMARY KEY,
    fromdate DATE,
    todate DATE,
    nopeopleattending INT,
    userid INT,
    listofservices VARCHAR(500),
    FOREIGN KEY (userid) REFERENCES User (userid)
);

CREATE TABLE Quotation (
    quotid INT PRIMARY KEY,
    packagetype VARCHAR(20) CHECK (packagetype IN ('Basic', 'Premium', 'Classic')),
    estimatedamt DOUBLE,
    vendorid INT,
    userid INT,
    requestid INT,
    quotstatus VARCHAR(10) CHECK (quotstatus IN ('Accepted', 'Pending', 'Rejected')) DEFAULT 'pending',
    FOREIGN KEY (vendorid) REFERENCES Vendor (vendorid),
    FOREIGN KEY (userid) REFERENCES User (userid),
    FOREIGN KEY (requestid) REFERENCES Planrequest (requestid)
);

CREATE TABLE Package (
    packageid INT PRIMARY KEY,
    packagetype VARCHAR(20) CHECK (packagetype IN ('Basic', 'Premium', 'Classic')),
    amount DOUBLE NOT NULL,
    vendorid INT,
    FOREIGN KEY (vendorid) REFERENCES Vendor (vendorid)
);
