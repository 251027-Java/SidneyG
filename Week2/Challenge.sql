-- Active: 1762364420266@@127.0.0.1@5432@challengedb
CREATE DATABASE challengeDB;

CREATE SCHEMA challengeDB;

/*******************************************************************************
   Create Tables
********************************************************************************/


-- PROFESSOR TABLE
CREATE TABLE ChallengeDB.Professor (
    professor_id INT PRIMARY KEY,
    professor_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE
);

-- STUDENT TABLE
CREATE TABLE ChallengeDB.Student (
    student_id INT PRIMARY KEY,
    student_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE
);

-- CLASS TABLE
CREATE TABLE ChallengeDB.Class (
    class_id INT PRIMARY KEY,
    class_name VARCHAR(100) NOT NULL,
    professor_id INT,
    schedule VARCHAR(50),
    FOREIGN KEY (professor_id) REFERENCES ChallengeDB.Professor(professor_id)
);

-- ENROLLMENT TABLE (Many-to-Many)
CREATE TABLE ChallengeDB.Enrollment (
    student_id INT,
    class_id INT,
    PRIMARY KEY (student_id, class_id),
    FOREIGN KEY (student_id) REFERENCES ChallengeDB.Student(student_id),
    FOREIGN KEY (class_id) REFERENCES ChallengeDB.Class(class_id)
);


/*
ALTER TABLE ChallengeDB.Student
DROP COLUMN major;
*/

/*******************************************************************************
   Populate Tables
********************************************************************************/


-- Professors
INSERT INTO ChallengeDB.Professor VALUES (1, 'Dr. Smith', 'smith@uni.edu');
INSERT INTO ChallengeDB.Professor VALUES (2, 'Dr. Brown', 'brown@uni.edu');
INSERT INTO ChallengeDB.Professor VALUES (3, 'Dr. Hawkins', 'hawkins@uni.edu');
INSERT INTO ChallengeDB.Professor VALUES (4, 'Dr. Bezos', 'bezos@uni.edu');

-- Students
INSERT INTO ChallengeDB.Student VALUES (1, 'Alice', 'alice@uni.edu');
INSERT INTO ChallengeDB.Student VALUES (2, 'Bob', 'bob@uni.edu');
INSERT INTO ChallengeDB.Student VALUES (3, 'Jeff', 'jeff@uni.edu');
INSERT INTO ChallengeDB.Student VALUES (4, 'Helen', 'helen@uni.edu');

-- Classes
INSERT INTO ChallengeDB.Class VALUES (101, 'Database Systems', 1, 'Mon 10AM');
INSERT INTO ChallengeDB.Class VALUES (102, 'Linear Algebra', 2, 'Tue 2PM');
INSERT INTO ChallengeDB.Class VALUES (103, 'English I', 3, 'Wed 3PM');
INSERT INTO ChallengeDB.Class VALUES (104, 'Computer Architecture', 1, 'Friday 8AM');

-- Enrollment
INSERT INTO ChallengeDB.Enrollment VALUES (1, 101);
INSERT INTO ChallengeDB.Enrollment VALUES (2, 102);
INSERT INTO ChallengeDB.Enrollment VALUES (4, 102);
INSERT INTO ChallengeDB.Enrollment VALUES (4, 104);


/*******************************************************************************
   Queries
********************************************************************************/

-- 1) List all professors
SELECT *
FROM challengedb.professor;

-- 2) List all students
SELECT *
FROM challengedb.student;

-- 3) List all classes with their professor (INNER JOIN)
SELECT c.class_id, c.class_name, c.schedule,
       p.professor_name
FROM challengedb.class AS c
JOIN challengedb.professor AS p ON p.professor_id = c.professor_id;

-- 4) Who is enrolled in which class?
SELECT s.student_name, c.class_name
FROM challengedb.enrollment e
JOIN challengedb.student   s ON s.student_id = e.student_id
JOIN challengedb.class     c ON c.class_id   = e.class_id
ORDER BY c.class_name, s.student_name;

