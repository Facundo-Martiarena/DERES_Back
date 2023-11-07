CREATE DATABASE IF NOT EXISTS `deres`;

USE `deres`;  
CREATE TABLE IF NOT EXISTS `user` (
  `username` varchar(63) NOT NULL,
  `password` varchar(63) NOT NULL,
  `privilege` varchar(63) NOT NULL,
  PRIMARY KEY (`username`)
);

INSERT INTO `user` (`username`, `password`, `privilege`) VALUES
('admin', 'admin', 'ADMIN'),
('user', 'user', 'USER'),
('provider', 'provider', 'PROVIDER'),
('all', 'all', 'ALL');
);