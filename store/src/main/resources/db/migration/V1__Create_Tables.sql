CREATE TABLE `role` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`title` varchar(50) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `category` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`title` varchar(100) NOT NULL,
	`parent` INT NOT NULL,
	PRIMARY KEY (`id`),
	FOREIGN KEY (`parent`) REFERENCES `category`(`id`)
);

CREATE TABLE `manufactor` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`title` varchar(100) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `product` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(100) NOT NULL,
	`quantity` INT NOT NULL,
	`price` INT NOT NULL,
	`manufactor` INT NOT NULL,
	`category` INT NOT NULL,
	PRIMARY KEY (`id`),
	FOREIGN KEY (`manufactor`) REFERENCES `manufactor`(`id`),
	FOREIGN KEY (`category`) REFERENCES `category`(`id`)
);

CREATE TABLE `user` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`login` varchar(50) NOT NULL UNIQUE,
	`password` varchar(25) NOT NULL,
	`phone` INT(35) NOT NULL,
	`address` varchar(100) NOT NULL,
	`role` INT NOT NULL,
	PRIMARY KEY (`id`),
	FOREIGN KEY (`role`) REFERENCES `role`(`id`)
);

CREATE TABLE `status` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(50) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `payment` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`method` varchar(50) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `address` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`country` varchar(50) NOT NULL,
	`city` varchar(50) NOT NULL,
	`street` varchar(50) NOT NULL,
	`house` INT NOT NULL,
	`apartment` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `order` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`status` INT NOT NULL,
	`address` INT NOT NULL,
	`payment` INT NOT NULL,
	`price` INT NOT NULL,
	PRIMARY KEY (`id`),
	FOREIGN KEY (`status`) REFERENCES `status`(`id`),
	FOREIGN KEY (`address`) REFERENCES `address`(`id`),
	FOREIGN KEY (`payment`) REFERENCES `payment`(`id`)
);

CREATE TABLE `order_item` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`order_id` INT NOT NULL,
	`product` INT NOT NULL,
	`quantity` INT NOT NULL,
	`price` INT NOT NULL,
	PRIMARY KEY (`id`),
	FOREIGN KEY (`order_id`) REFERENCES `order`(`id`),
	FOREIGN KEY (`product`) REFERENCES `product`(`id`)
);

CREATE TABLE `cart` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`user` INT NOT NULL,
	`price` INT NOT NULL,
	PRIMARY KEY (`id`),
	FOREIGN KEY (`user`) REFERENCES `user`(`id`)
);

CREATE TABLE `cart_item` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`cart_id` INT NOT NULL,
	`product` INT NOT NULL,
	`quantity` INT NOT NULL,
	`price` INT NOT NULL,
	PRIMARY KEY (`id`),
	FOREIGN KEY (`cart_id`) REFERENCES `cart`(`id`),
	FOREIGN KEY (`product`) REFERENCES `product`(`id`)
);

CREATE TABLE `billing` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`user_id` INT NOT NULL,
	`address` INT NOT NULL,
	PRIMARY KEY (`id`),
	FOREIGN KEY (`user_id`) REFERENCES `user`(`id`),
	FOREIGN KEY (`address`) REFERENCES `address`(`id`)
);