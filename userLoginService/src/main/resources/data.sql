DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS appointments;


CREATE TABLE user (
     id int(11) unsigned NOT NULL AUTO_INCREMENT,
     username varchar(20) NOT NULL DEFAULT '',
     password varchar(20) NOT NULL DEFAULT '',
     active tinyint(1) NOT NULL DEFAULT '1',
     roles varchar(200) NOT NULL DEFAULT '',
     permissions varchar(200) NOT NULL DEFAULT '',
     PRIMARY KEY (id)
);


CREATE TABLE appointments (
    id BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    customer_name VARCHAR(255) NOT NULL,
    appointment_time DATETIME NOT NULL,
    status VARCHAR(255) NOT NULL DEFAULT 'SCHEDULED',
    PRIMARY KEY (id)
);

INSERT INTO user (username, password, active, roles, permissions) VALUES
    ('dan', '1234', 1, '', ''),
    ('alon', '12345', 1, '', '');

INSERT INTO appointments (customer_name, appointment_time, status) VALUES
    ('John Doe', '2024-10-30 14:30:00', 'SCHEDULED'),
    ('Jane Smith', '2024-10-31 09:00:00', 'SCHEDULED');