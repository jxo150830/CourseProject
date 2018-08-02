package db;

public interface MyDB {
	String USER = "coursedatabase_admin";
	String PASS = "Test1234";
	String CONN_URL = "jdbc:mysql://localhost:3306/coursedatabase?autoReconnect=true&useSSL=false";
}
/**
CREATE TABLE customer (
	id int NOT NULL AUTO_INCREMENT,
	name char(32) NOT NULL,
	username char(32) NOT NULL,
	password char(32) NOT NULL,
	level int NOT NULL DEFAULT 1,
	color char(6) NOT NULL DEFAULT "4b4b4b",
	about char(255) NOT NULL DEFAULT "This user has nothing to say about themselves.",
	is_enterprise int NOT NULL DEFAULT 0,
	enterprise int NOT NULL DEFAULT 0,
	PRIMARY KEY (id),
	UNIQUE (id),
	UNIQUE (username)
);

CREATE TABLE message (
	sender_id int NOT NULL,
	receiver_id int NOT NULL,
	date char(64) NOT NULL,
	subject char(32) NOT NULL,
	body char(255) NOT NULL,
	FOREIGN KEY (sender_id) REFERENCES customer(id),
	FOREIGN KEY (receiver_id) REFERENCES customer(id)
)
*/