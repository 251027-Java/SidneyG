-- Active: 1762364420266@@127.0.0.1@5432@mysampledb
CREATE DATABASE mySampleDb;

-- dont forget to switch to the new database!
CREATE SCHEMA mySampleSchema;

CREATE TABLE mySampleSchema.myNewTable (
    -- id INTEGER UNIQUE NOT NULL,
    id INTEGER PRIMARY KEY,
    email VARCHAR(100),
    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    salary FLOAT CHECK (salary > 0), --if salary is not greater than 0 then STOP
    --secondSalary DOUBLE,
    thirdSalary DECIMAL,
    fourthSalary NUMERIC (10,2) -- precision (total number of digits), scale (maximum number of digits to the right of the decimal);
)

CREATE TABLE mySampleSchema.AnotherSimpleTable (
    id INTEGER PRIMARY KEY,
    name VARCHAR(100)

    --CONSTRAINT
);

ALTER TABLE mySampleSchema.AnotherSimpleTable
ADD Column newTable_id INTEGER;

Alter TABLE mySampleSchema.AnotherSimpleTable
ADD CONSTRAINT fk_newTable_id
FOREiGN KEY (newTable_id) REFERENCES mySampleSchema.myNewTable (id);

DROP TABLE mySampleSchema.myNewTable;

DROP TABLE mySampleSchema.AnotherSimpleTable;

DROP CONSTRAINT fk_newTable_id;

