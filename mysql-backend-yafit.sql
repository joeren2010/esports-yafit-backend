-- create database
CREATE DATABASE yafit_db;
USE yafit_db;


-- create table: admin
CREATE TABLE admins( 
  adminId			INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT, 
  adminName 		VARCHAR(255) NOT NULL,
  adminEmail		VARCHAR(50) NOT NULL,
  adminPassword		VARCHAR(50) NOT NULL, 
  loginType 		INTEGER DEFAULT 1,
  addedOn 		    DATETIME DEFAULT CURRENT_TIMESTAMP 
);
SHOW TABLES;
DESC admins;
SELECT * FROM admins;

-- create table: trainers
CREATE TABLE trainers(
  trnrId         	   INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  trnrName   	       VARCHAR(255) NOT NULL,
  trnrEmail        	   VARCHAR(50) NOT NULL,
  trnrPassword         VARCHAR(50) NOT NULL,
  trnrStreet           VARCHAR(50) DEFAULT NULL,
  trnrCity             VARCHAR(50) DEFAULT NULL,
  trnrState            VARCHAR(50) DEFAULT NULL,
  trnrZipcode          INTEGER,
  trnrAge              INTEGER,
  trnrGender           VARCHAR(50) DEFAULT NULL,
  trnrImage            VARCHAR(1000),
  trnrPhone 	       VARCHAR(20),
  trnrTitle            VARCHAR(255) NOT NULL,
  trnrRating           INTEGER NOT NULL,
  trnrActive		   INTEGER DEFAULT 0,
  addedOn              DATETIME DEFAULT CURRENT_TIMESTAMP
);
SHOW TABLES;
DESC trainers;
SELECT * FROM trainers;

-- create table: participants
CREATE TABLE participants(
  partId         	   INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  partName         	   VARCHAR(255) NOT NULL,
  partEmail            VARCHAR(50) NOT NULL,
  partPassword         VARCHAR(50) NOT NULL,
  partStreet           VARCHAR(50) DEFAULT NULL,
  partCity             VARCHAR(50) DEFAULT NULL,
  partState            VARCHAR(50) DEFAULT NULL,
  partCountry          VARCHAR(50) DEFAULT NULL,
  partZipcode          INTEGER,
  partAge              INTEGER,
  partGender           VARCHAR(50) DEFAULT NULL,
  partImage            VARCHAR(1000),
  partPhone            VARCHAR(20),
  emergPhone           VARCHAR(255) NOT NULL,
  partType     	       VARCHAR(255) NOT NULL,
  partActive		   INTEGER DEFAULT 0,
  addedOn              DATETIME DEFAULT CURRENT_TIMESTAMP
);
SHOW TABLES;
DESC participants;
SELECT * FROM participants;

-- create table: payments
CREATE TABLE payments(
  paymentId    	        INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  partId                INTEGER,
  partName         	    VARCHAR(255) NOT NULL,
  partEmail             VARCHAR(50) NOT NULL,
  partPhone             VARCHAR(20),
  partType        	    VARCHAR(255) NOT NULL,
  paymentPlan           VARCHAR(255) NOT NULL,
  billingDay            INTEGER DEFAULT 5,
  paymentStatus         VARCHAR(255),
  paymentAmount         INTEGER NOT NULL,
  partActive            INTEGER DEFAULT 0,
  addedOn               DATETIME DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (partId)  REFERENCES participants(partId)
);
SHOW TABLES;
DESC payments;
SELECT * FROM payments;

-- create table: batches
CREATE TABLE batches(
  batchId               INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  batchName             VARCHAR(255) NOT NULL,
  trnrName	            VARCHAR(255) NOT NULL,
  trnrId	            INTEGER,
  partName	            VARCHAR(255) NOT NULL,
  partId	            INTEGER,
  partAge               INTEGER,
  partGender    	    VARCHAR(50) DEFAULT NULL,
  partActive            INTEGER DEFAULT 0,
  addedOn               DATETIME DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (trnrId)  REFERENCES trainers(trnrId),
  FOREIGN KEY (partId)  REFERENCES participants(partId)
);
SHOW TABLES;
DESC batches;
SELECT * FROM batches;
