CREATE DATABASE IF NOT EXISTS `deres`;

USE `deres`;  
CREATE TABLE IF NOT EXISTS `user` (
  `username` varchar(63) NOT NULL,
  `password` varchar(63) NOT NULL,
  `privilege` varchar(63) NOT NULL,
  `email` varchar(63) NOT NULL,
  PRIMARY KEY (`username`)
);

CREATE TABLE IF NOT EXISTS `provider` (
  `name` varchar(63) NOT NULL,
  `rut` varchar(63) NOT NULL,
  `type` varchar(63) NOT NULL,
  `score` varchar(63) NOT NULL,
  PRIMARY KEY (`name`),
  UNIQUE KEY `rut` (`rut`)
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

INSERT INTO `user` (`username`, `password`, `privilege`, `email`) VALUES
('admin', 'admin', 'ADMIN', 'admin@admin.com'),
('user', 'user', 'USER', 'user@user.com'),
('provider', 'provider', 'PROVIDER', 'provider@provider.com'),
('all', 'all', 'ALL', 'all@all.com');

INSERT INTO `provider` (`name`, `rut`, `type`, `score`) VALUES
('provider1', '111', 'tipo1', '20'),
('provider2', '222', 'tipo2', '50'),
('provider3', '333', 'tipo3', '98'),
('provider4', '444', 'tipo4', '15');

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