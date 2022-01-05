create table user(
	user_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(50) NOT NULL,
	user_username VARCHAR(30) NOT NULL,
	user_password VARCHAR(30) NOT NULL,
    user_phone VARCHAR(10) NOT NULL,
    user_type ENUM('admin', 'customer')
);

INSERT INTO user (user_name, user_username, user_password, user_phone, user_type)
VALUES ('Ger', 'gergarage','admin', '0831119999','Admin');


create table booking_service (
	booking_service_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    type_service VARCHAR(30) NOT NULL,
    cost DOUBLE(5,2) NOT NULL
);

INSERT INTO booking_service (type_service, cost)
VALUES ('Annual Service', 200.00);
INSERT INTO booking_service (type_service, cost)
VALUES (' Major Service', 500.00);
INSERT INTO booking_service (type_service, cost)
VALUES ('Repair / Fault', 250.00);
INSERT INTO booking_service (type_service, cost)
VALUES ('Major Repair', 700.00);


create table make (
	make_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    make_name VARCHAR(30) NOT NULL
);

INSERT INTO make (make_name) VALUES ('Audi');
INSERT INTO make (make_name) VALUES ('BMW');
INSERT INTO make (make_name) VALUES ('Ford');
INSERT INTO make (make_name) VALUES ('Mercedes-Benz');
INSERT INTO make (make_name) VALUES ('Peugeot');
INSERT INTO make (make_name) VALUES ('Porsche');
INSERT INTO make (make_name) VALUES ('Renault');
INSERT INTO make (make_name) VALUES ('Smart');
INSERT INTO make (make_name) VALUES ('Volkswagen');


create table model (
	model_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    model_name VARCHAR(30) NOT NULL,
    make_id INT UNSIGNED NOT NULL,
    FOREIGN KEY (make_id) REFERENCES make(make_id)
);

INSERT INTO model (model_name, make_id) VALUES ('A3', 1);
INSERT INTO model (model_name, make_id) VALUES ('3 Series', 2);
INSERT INTO model (model_name, make_id) VALUES ('Fiesta', 3);
INSERT INTO model (model_name, make_id) VALUES ('C Class', 4);
INSERT INTO model (model_name, make_id) VALUES ('306', 5);
INSERT INTO model (model_name, make_id) VALUES ('Sandero', 6);
INSERT INTO model (model_name, make_id) VALUES ('911', 7);
INSERT INTO model (model_name, make_id) VALUES ('Fortwo', 8);
INSERT INTO model (model_name, make_id) VALUES ('Beetle', 9);



create table vehicle (
	vehicle_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    vehicle_comment VARCHAR(200),
    vehicle_licence VARCHAR(10) NOT NULL,
    engine_type ENUM('Diesel', 'Petrol', 'Hybrid', 'Electric'),
    user_id INT UNSIGNED NOT NULL,
    model_id INT UNSIGNED NOT NULL,
    booking_service INT UNSIGNED NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user(user_id),
    FOREIGN KEY (model_id) REFERENCES model(model_id),
    FOREIGN KEY (booking_service) REFERENCES booking_service(booking_service_id)
);



create table mechanic (
	mechanic_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    mechanic_name VARCHAR(30)
);


create table part (
	part_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    part_name VARCHAR(30),
    part_price DOUBLE(5,2)
);

create table service (
	service_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    service_name VARCHAR(30),
    service_cost DOUBLE(5,2),
    part_id INT UNSIGNED,
    FOREIGN KEY (part_id) REFERENCES part(part_id)
);


create table booking (
	booking_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    booking_date DATE,
    booking_status ENUM ('Booked','In Service','Fixed / Completed ','Collected','Unrepairable / Scrapped'),
    mechanic_id INT UNSIGNED NOT NULL,
    vehicle_id int UNSIGNED NOT NULL,
    FOREIGN KEY (mechanic_id) REFERENCES mechanic(mechanic_id),
    FOREIGN KEY (vehicle_id) REFERENCES vehicle(vehicle_id)    
);



create table costs (
	service_id INT UNSIGNED NOT NULL,
    booking_id INT UNSIGNED NOT NULL,
    FOREIGN KEY (service_id) REFERENCES service(service_id),
    FOREIGN KEY (booking_id) REFERENCES booking(booking_id)    
);

