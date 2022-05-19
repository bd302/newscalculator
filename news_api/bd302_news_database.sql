-- phpMyAdmin SQL Dump
-- version 4.9.7
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: May 19, 2022 at 07:59 PM
-- Server version: 5.7.38
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bd302_news_database`
--

-- --------------------------------------------------------

--
-- Table structure for table `table1`
--

CREATE TABLE `table1` (
  `nhsNo` varchar(10) NOT NULL,
  `firstname` varchar(64) NOT NULL,
  `lastname` varchar(64) NOT NULL,
  `dob` varchar(10) DEFAULT NULL,
  `respiration` int(2) NOT NULL,
  `sp02` int(2) NOT NULL,
  `sp02scale` tinyint(4) NOT NULL,
  `oxygen` varchar(6) NOT NULL,
  `bloodpressure` int(3) NOT NULL,
  `pulse` int(3) NOT NULL,
  `cons` varchar(32) NOT NULL,
  `temp` float NOT NULL,
  `finalscore` int(2) NOT NULL,
  `redflag` tinyint(1) NOT NULL,
  `risk` varchar(32) NOT NULL,
  `response` varchar(256) NOT NULL,
  `initials` varchar(16) NOT NULL,
  `time` datetime NOT NULL,
  `nexttime` datetime NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `table1`
--

INSERT INTO `table1` (`nhsNo`, `firstname`, `lastname`, `dob`, `respiration`, `sp02`, `sp02scale`, `oxygen`, `bloodpressure`, `pulse`, `cons`, `temp`, `finalscore`, `redflag`, `risk`, `response`, `initials`, `time`, `nexttime`) VALUES
('3333', 'leg', 'cheg', '22-22-22', 21, 12, 0, 'Oxygen', 12, 12, 'Pain', 12, 19, 1, 'High', 'Urgent or emergency response', 'JS', '2022-05-08 14:19:18', '2022-05-08 15:19:18'),
('123', 'leg', 'cheg', '123', 123, 123, 0, 'Air', 123, 123, 'Alert', 33.3, 8, 1, 'High', 'Urgent or emergency response', 'BD', '2022-05-08 13:00:24', '2022-05-08 14:00:24'),
('218471', 'leg', 'cheg', '22-22-22', 112, 12, 0, 'Oxygen', 12, 12, 'Confused', 12.2, 20, 1, 'High', 'Urgent or emergency response', 'BD', '2022-05-08 12:50:40', '2022-05-08 13:50:40'),
('3333', 'leg', 'cheg', '22-2-22', 21, 12, 0, 'Air', 12, 12, 'Voice', 12, 17, 1, 'High', 'Urgent or emergency response', 'BD', '2022-05-08 12:49:14', '2022-05-08 13:49:14'),
('1243455', 'jaguar', 'SKILLs', '12141', 12, 12, 0, 'Oxygen', 12, 12, 'Confused', 12, 17, 1, 'High', 'Urgent or emergency response', 'BD', '2022-05-08 12:45:49', '2022-05-08 13:45:49'),
('12345678', 'uncle', 'trev', '22-1-22', 12, 32, 0, 'Oxygen', 123, 201, 'Voice', 21, 14, 1, 'High', 'Urgent or emergency response', 'BD', '2022-05-08 12:02:48', '2022-05-08 13:02:48'),
('500', 'Jon', 'Higgs', '26-4-23', 12, 12, 0, 'Air', 12, 12, 'Unresponsive', 12, 15, 1, 'High', 'Urgent or emergency response', 'BD', '2022-05-08 11:49:51', '2022-05-08 12:49:51'),
('1234', 'trevor', 'nelson', '000', 18, 99, 1, 'Air', 125, 75, 'Confused', 37, 3, 1, 'Low-medium', 'Urgent ward-based response', 'BD', '2022-05-07 13:20:25', '2022-05-07 14:20:25'),
('542', 'Kanye', 'West', '22-2-22', 16, 99, 1, 'Air', 136, 102, 'Alert', 37.5, 1, 1, 'Low', 'Ward-based response', 'BD', '2022-05-07 13:11:35', '2022-05-07 17:11:35'),
('13214', 'trevor', 'nelson', '221', 16, 99, 1, 'Air', 136, 102, 'Alert', 37.5, 1, 1, 'Low', 'Ward-based response', 'BD', '2022-05-07 13:15:11', '2022-05-07 17:15:11'),
('1', 'cheg1', 'leg1', '1', 1, 1, 1, 'Air', 1, 1, 'Alert', 1, 15, 1, 'High', 'Urgent or emergency response', '11', '2022-05-06 12:10:58', '2022-05-06 13:10:58'),
('2', 'cheg2', 'leg2', '2', 2, 2, 0, 'Air', 2, 2, 'Alert', 2, 15, 1, 'High', 'Urgent or emergency response', '2', '2022-05-06 12:11:02', '2022-05-06 13:11:02'),
('123414', 'surname', 'me', '22-2-22', 12, 12, 0, 'Air', 12, 12, 'Confused', 12, 15, 1, 'High', 'Urgent or emergency response', '2', '2022-05-06 12:15:35', '2022-05-06 13:15:35'),
('12', 'firstname', 'lastname', '12', 12, 12, 1, 'Oxygen', 12, 12, 'Confused', 12, 17, 1, 'High', 'Urgent or emergency response', 'leg', '2022-05-06 12:19:44', '2022-05-06 13:19:44'),
('69', 'new', 'day', 'nice.', 12, 12, 0, 'Oxygen', 12, 12, 'Confused', 12, 17, 1, 'High', 'Urgent or emergency response', 'BD', '2022-05-07 11:03:36', '2022-05-07 12:03:36'),
('1234567890', 'trevor ', 'nelson', '22-22-22', 22, 22, 1, 'Oxygen', 22, 22, 'Unresponsive', 22, 19, 1, 'High', 'Urgent or emergency response', 'BD', '2022-05-11 11:49:33', '2022-05-11 12:49:33'),
('0987654321', 'chris', 'moyles', '22-2-22', 12, 43, 0, 'Oxygen', 124, 53, 'Confused', 36.4, 8, 1, 'High', 'Urgent or emergency response', 'BD', '2022-05-07 12:28:53', '2022-05-07 13:28:53'),
('666', 'Jaguar', 'Skills', '06-05-22', 19, 97, 1, 'Air', 170, 79, 'Alert', 38.5, 1, 1, 'Low', 'Ward-based response', 'BD', '2022-05-07 12:35:11', '2022-05-07 16:35:11'),
('666', 'Jaguar', 'Skills', '06-05-22', 19, 97, 0, 'Air', 170, 79, 'Alert', 38.5, 1, 1, 'Low', 'Ward-based response', 'BD', '2022-05-07 12:38:04', '2022-05-07 16:38:04'),
('123', 'cheg', 'leg', '2201', 12, 12, 0, 'Oxygen', 12, 12, 'Voice', 12, 17, 1, 'High', 'Urgent or emergency response', 'BD', '2022-05-07 12:42:20', '2022-05-07 13:42:20'),
('2', '2', '2', '2', 2, 2, 0, 'Oxygen', 2, 2, 'Confused', 2, 20, 1, 'High', 'Urgent or emergency response', '12', '2022-05-06 12:08:44', '2022-05-06 13:08:44'),
('3333', 'cheg', 'leg', '3321', 12, 12, 1, 'Oxygen', 12, 12, 'Confused', 12, 17, 1, 'High', 'Urgent or emergency response', 'ad', '2022-05-06 12:07:32', '2022-05-06 13:07:32'),
('12', 'cheg', 'leg ', '12', 12, 12, 0, 'Air', 12, 12, 'Confused', 12, 15, 1, 'High', 'Urgent or emergency response', 'should be 0', '2022-05-06 11:57:20', '2022-05-06 12:57:20'),
('21', 'cheg', 'leg', '12', 12, 12, 0, 'Air', 12, 12, 'Alert', 12, 12, 1, 'High', 'Urgent or emergency response', '', '2022-05-06 12:00:46', '2022-05-06 13:00:46'),
('123', 'cheg123', 'leg123', '123', 123, 1, 0, 'Oxygen', 123, 123, 'Alert', 12, 13, 1, 'High', 'Urgent or emergency response', 'LEG', '2022-05-06 12:02:03', '2022-05-06 13:02:03'),
('12', 'pls', '2forachange', '121', 12, 12, 0, 'Oxygen', 12, 12, 'Confused', 12, 17, 1, 'High', 'Urgent or emergency response', '2', '2022-05-06 12:03:58', '2022-05-06 13:03:58'),
('87', 'JAg ', 'Skills', '22-22-22', 13, 98, 1, 'Air', 120, 55, 'Alert', 37.5, 0, 1, 'Low', 'Ward-based response', 'BD', '2022-05-16 11:58:31', '2022-05-16 23:58:31'),
('123', 'leg', 'cheg', '123', 123, 123, 1, 'Air', 123, 123, 'Alert', 123, 7, 1, 'High', 'Urgent or emergency response', 'BD', '2022-05-08 15:06:16', '2022-05-08 16:06:16'),
('123', 'leg', 'cheg', '113', 123, 123, 0, 'Air', 123, 123, 'Alert', 123, 7, 1, 'High', 'Urgent or emergency response', 'BD', '2022-05-08 15:08:09', '2022-05-08 16:08:09'),
('213', 'leg', 'cheg', '123', 123, 123, 1, 'Air', 123, 123, 'Alert', 123, 7, 1, 'High', 'Urgent or emergency response', 'BD', '2022-05-08 15:09:43', '2022-05-08 16:09:43'),
('123', 'leg', 'xcheg', '213', 123, 123, 1, 'Air', 123, 123, 'Alert', 123, 7, 1, 'High', 'Urgent or emergency response', 'BD', '2022-05-08 15:12:17', '2022-05-08 16:12:17'),
('123', 'leg', 'cheg', '123', 123, 123, 1, 'Air', 123, 123, 'Alert', 123, 7, 1, 'High', 'Urgent or emergency response', 'BD', '2022-05-08 15:17:52', '2022-05-08 16:17:52'),
('123', 'leg', 'cheg', '123', 123, 123, 1, 'Air', 123, 123, 'Alert', 123, 7, 1, 'High', 'Urgent or emergency response', 'BD', '2022-05-08 15:19:18', '2022-05-08 16:19:18'),
('123', 'Jag', 'Trev', '123', 123, 123, 1, 'Air', 123, 123, 'Voice', 123, 10, 1, 'High', 'Urgent or emergency response', 'JS', '2022-05-09 16:50:02', '2022-05-09 17:50:02'),
('1231245', 'kanye ', 'west', '22-22-22', 123, 123, 1, 'Air', 123, 123, 'Alert', 123, 7, 1, 'High', 'Urgent or emergency response', 'BD', '2022-05-11 11:50:56', '2022-05-11 12:50:56'),
('123', 'marhsall', 'mathers', '123456', 12, 12, 1, 'Air', 21, 21, 'Alert', 12, 12, 1, 'High', 'Urgent or emergency response', 'BD', '2022-05-11 11:52:35', '2022-05-11 12:52:35'),
('1234567890', 'Joe', 'Bloggs', '22-22-22', 12, 12, 0, 'Air', 12, 12, 'Alert', 12, 12, 1, 'High', 'Urgent or emergency response', 'BD', '2022-05-11 14:48:57', '2022-05-11 15:48:57'),
('123', 'complete', 'test', '123', 12, 12, 1, 'Oxygen', 12, 12, 'Voice', 12, 17, 1, 'High', 'Urgent or emergency response', 'BD', '2022-05-13 16:07:04', '2022-05-13 17:07:04'),
('999999999', 'Joe', 'Bloggs', '13/5/22', 12, 12, 1, 'Air', 12, 21, 'Alert', 12, 12, 1, 'High', 'Urgent or emergency response', 'BD', '2022-05-13 16:58:06', '2022-05-13 17:58:06'),
('87', 'JAg ', 'Skills', '22-22-22', 13, 98, 1, 'Air', 120, 55, 'Unresponsive', 37.5, 3, 1, 'Low-medium', 'Urgent ward-based response', 'BD', '2022-05-16 11:58:48', '2022-05-16 12:58:48'),
('87', 'JAg ', 'Skills', '22-22-22', 13, 98, 1, 'Oxygen', 120, 55, 'Unresponsive', 37.5, 5, 1, 'Medium', 'Key threshold for urgent response', 'BD', '2022-05-16 11:59:07', '2022-05-16 12:59:07'),
('87', 'JAg ', 'Skills', '22-22-22', 13, 92, 1, 'Oxygen', 120, 55, 'Unresponsive', 37.5, 7, 1, 'High', 'Urgent or emergency response', 'BD', '2022-05-16 11:59:27', '2022-05-16 12:59:27'),
('12345', 'Brad', 'Durrance', '01-08-2001', 10, 97, 0, 'Oxygen', 140, 105, 'Confused', 37.5, 8, 1, 'High', 'Urgent or emergency response', 'RE', '2022-05-19 16:26:14', '2022-05-19 17:26:14');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `table1`
--
ALTER TABLE `table1`
  ADD PRIMARY KEY (`nhsNo`,`time`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
