CREATE DATABASE IF NOT EXISTS `deres`;

USE `deres`;  
CREATE TABLE IF NOT EXISTS `user` (
  `username` varchar(63) NOT NULL,
  `password` varchar(63) NOT NULL,
  `privilege` varchar(63) NOT NULL,
  `email` varchar(63) NOT NULL,
  `provider_id` VARCHAR(63),
  PRIMARY KEY (`username`)
);

CREATE TABLE IF NOT EXISTS `provider` (
  `name` varchar(63) NOT NULL,
  `rut` varchar(63) NOT NULL,
  `type` varchar(63) NOT NULL,
  `score` varchar(63) NOT NULL,
  `contact` VARCHAR(63) NOT NULL,
  `email` VARCHAR(63) NOT NULL,
  `phone` VARCHAR(63) NOT NULL,
  `address` VARCHAR(63) NOT NULL,
  PRIMARY KEY (`rut`),
  UNIQUE KEY `name` (`name`)
);

CREATE TABLE IF NOT EXISTS `question` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `question` varchar(255) NOT NULL,
  `type` varchar(63) NOT NULL,
  `ponderation` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `answer` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `answer` boolean NOT NULL,
  `question_id` BIGINT NOT NULL,
  `provider_rut` varchar(63) NOT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `user` (`username`, `password`, `privilege`, `email`, `provider_id`) VALUES
('admin', 'admin', 'ADMIN', 'admin@admin.com', null),
('user', 'user', 'USER', 'user@user.com', null),
('provider', 'provider', 'PROVIDER', 'facumartiarena1995@gmail.com', '111'),
('all', 'all', 'ALL', 'all@all.com', null);

INSERT INTO `provider` (`name`, `rut`, `type`, `score`, `contact`, `email`, `phone`, `address`) VALUES
('provider1', '111', 'tipo1', '20', 'fede', 'fede@provider1.com', '065046', 'calle 123'),
('provider2', '222', 'tipo2', '50', 'agus', 'agus@provider2.com', '234824', 'calle 456'),
('provider3', '333', 'tipo3', '98', 'hernan', 'hernan@provider3.com', '090787', 'calle 789'),
('provider4', '444', 'tipo4', '15', 'cecilia', 'cecilia@provider4.com', '565868', 'calle 874');


INSERT INTO `question` (`question`, `type`, `ponderation`) VALUES
('test 1', 'AMBIENTAL', '50'),
('test 2', 'AMBIENTAL', '50'),
('test social', 'SOCIAL', '100');

INSERT INTO `answer` (`answer`, `question_id`, `provider_rut`) VALUES
(true, 1, '111'),
(true, 1, '222'),
(true, 1, '333'),
(false, 2, '111'),
(true, 2, '222'),
(false, 2, '333'),
(false, 3, '111'),
(true, 3, '222'),
(true, 3, '333');