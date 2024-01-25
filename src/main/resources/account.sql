-- drop table user;

CREATE TABLE 'user' (
    project_id INT PRIMARY KEY
    'user_id' VARCHAR(20) NOT NULL,
    'user_password' VARCHAR(50) NOT NULL,
    'user_email' VARCHAR(100) NOT NULL,
    'user_status' ENUM('active','dormant','closed') NOT NULL
);