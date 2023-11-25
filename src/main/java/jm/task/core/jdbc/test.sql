CREATE TABLE cats (
                      id INT PRIMARY KEY AUTO_INCREMENT,
                      name VARCHAR(255),
                      breed VARCHAR(255),
                      age INT
);

-- Insert a cat into the "cats" table
INSERT INTO cats (name, breed, age)
VALUES ('Whiskers', 'Persian', 3);

CREATE TABLE IF NOT EXISTS users (id BIGINT PRIMARY KEY AUTO_INCREMENT,
                   name VARCHAR(255),
                    lastName VARCHAR(255),
                    age TINYINT)

DROP TABLE IF EXISTS users

DELETE FROM users WHERE id =?