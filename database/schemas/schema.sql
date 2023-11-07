CREATE DATABASE IF NOT EXISTS `deres`;

USE `deres`;  
CREATE TABLE IF NOT EXISTS `user` (
  `username` varchar(63) NOT NULL,
  `password` varchar(63) NOT NULL,
  `privilege` varchar(63) NOT NULL,
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
  `id` int(40) NOT NULL,
  `question` varchar(255) NOT NULL,
  `type` varchar(63) NOT NULL,
  `ponderable` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
)

INSERT INTO `user` (`username`, `password`, `privilege`) VALUES
('admin', 'admin', 'ADMIN'),
('user', 'user', 'USER'),
('provider', 'provider', 'PROVIDER'),
('all', 'all', 'ALL');

INSERT INTO `provider` (`name`, `rut`, `type`, `score`) VALUES
('provider1', '111', 'tipo1', '20'),
('provider2', '222', 'tipo2', '50'),
('provider3', '333', 'tipo3', '98'),
('provider4', '444', 'tipo4', '15');

INSERT INTO `question` (`id`, `question`, `type`, `ponderable`) VALUES
(1, 'test 1', 'AMBIENTAL', '50'),
(2, 'test 2', 'AMBIENTAL', '50'),
(3, 'test social', 'SOCIAL', '100');