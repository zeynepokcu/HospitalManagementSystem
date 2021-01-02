A Desktop Hospital Management-Appointment Booking System built with Java Swing

Product Functions
The key features are listed below:-

For Patients:
-Register as an patient account
-Delete their own account
-Booking an appointment
-Searching an appointment
-See their appointment information
-See doctor availability
-Search clinic and doctor

For Admin:
-Register as an admin account
-Delete their own account
-Add patient, doctor, polyclinic, room, payment in database
-Delete patient, doctor, polyclinic, appointment, room, payment from database
-Update patient, doctor, polyclinic, appointment, room, payment
-Show all patients, doctors, polyclinics, appointments, rooms, payments

Technologies used:
-Netbeans IDE
-MySQL for database

Tables for database:

create table users(username varchar(15) NOT NULL, name varchar(40) NOT NULL, password varchar(20) NOT NULL, question varchar(50) NOT NULL, answer varchar(30) NOT NULL, ltype varchar(15) NOT NULL);

create table patients(patientID integer NOT NULL primary key AUTO_INCREMENT, 
                    	  patientName varchar(20) NOT NULL, 
                    	  patientSurname varchar(20) NOT NULL, 
		  patientTC varchar(11) UNIQUE NOT NULL,
                      	  gender varchar(10) NOT NULL, 
                      	  contactno varchar(11) UNIQUE,
                     	  btype varchar(10) NOT NULL,
                      	  polyclinic varchar(50) NOT NULL,
                      	  disease varchar(50) NOT NULL,
                      	  roomno integer);

create table doctors(doctorID integer NOT NULL primary key AUTO_INCREMENT,
		 doctorName varchar(20) NOT NULL,
		 doctorSurname varchar(20) NOT NULL,
		 doctorTC varchar(11) UNIQUE NOT NULL,
		 gender varchar(10) NOT NULL,
		 contactno varchar(11) UNIQUE,
		 polyclinic varchar(50) NOT NULL);


create table appointments(appointmentID integer NOT NULL primary key AUTO_INCREMENT,
		          polyclinic varchar(50) NOT NULL,
		          doctor varchar(20) NOT NULL,
		          date DATE NOT NULL,
		          time TIME NOT NULL,
		          patientTC varchar(11) NOT NULL,
		          patientName varchar(20) NOT NULL,
		          patientSurname varchar(20) NOT NULL);

create table rooms(polyclinic varchar(50) NOT NULL,
		roomNo integer NOT NULL primary key,
		rdate DATE NOT NULL,
		rtime TIME NOT NULL,
		ldate DATE NOT NULL,
		ltime TIME NOT NULL,
		patientTC varchar(11) NOT NULL,
		patientName varchar(20) NOT NULL,
		patientSurname varchar(20) NOT NULL);

create table payments(paymentNo integer NOT NULL primary key  AUTO_INCREMENT,
		     patientTC varchar(11) NOT NULL,
		     patientName varchar(20) NOT NULL,
		     patientSurname varchar(20) NOT NULL,
		     bill float NOT NULL,
		     didPay varchar(10),
		     payDate DATE,
		     payTime TIME);

create table polyclinics(polyclinicNo integer NOT NULL primary key AUTO_INCREMENT,
		     polyclinicName varchar(50) NOT NULL); 
