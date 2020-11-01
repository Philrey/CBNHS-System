-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 01, 2020 at 12:53 PM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.2.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `final_cbnhs_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

CREATE TABLE `attendance` (
  `id` int(11) NOT NULL,
  `studentId` int(11) NOT NULL,
  `sectionId` int(11) NOT NULL,
  `subjectId` int(11) NOT NULL DEFAULT '0',
  `status` varchar(10) NOT NULL DEFAULT 'Present',
  `dateAdded` datetime NOT NULL,
  `notes` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `attendance`
--

INSERT INTO `attendance` (`id`, `studentId`, `sectionId`, `subjectId`, `status`, `dateAdded`, `notes`) VALUES
(28, 6, 7, 52, 'Absent', '2020-02-10 17:52:45', 'Notes'),
(29, 3, 7, 52, 'Present', '2020-02-10 17:52:45', 'Notes'),
(30, 5, 7, 52, 'Absent', '2020-02-10 17:52:45', 'Notes'),
(31, 8, 7, 52, 'Present', '2020-02-10 17:52:45', 'Notes'),
(32, 7, 7, 52, 'Present', '2020-02-10 17:52:45', 'Notes'),
(33, 6, 8, 53, 'Present', '2020-02-11 16:40:58', 'Notes'),
(34, 4, 8, 53, 'Present', '2020-02-11 16:40:58', 'Notes'),
(35, 1, 8, 53, 'Present', '2020-02-11 16:40:58', 'Notes'),
(36, 6, 8, 27, 'Absent', '2020-02-11 16:56:46', 'Notes'),
(37, 4, 8, 27, 'Present', '2020-02-11 16:56:46', 'Notes'),
(38, 1, 8, 27, 'Present', '2020-02-11 16:56:46', 'Notes'),
(40, 3, 7, 13, 'Present', '2020-02-12 15:30:12', 'Notes'),
(41, 5, 7, 13, 'Present', '2020-02-12 15:30:12', 'Notes'),
(42, 8, 7, 13, 'Present', '2020-02-12 15:30:12', 'Notes'),
(43, 7, 7, 13, 'Present', '2020-02-12 15:30:12', 'Notes'),
(44, 6, 8, 53, 'Present', '2020-02-14 10:41:00', 'Notes'),
(45, 4, 8, 53, 'Absent', '2020-02-14 10:41:00', 'Notes'),
(46, 1, 8, 53, 'Late', '2020-02-14 10:41:00', 'Arrived 20 minutes Late'),
(47, 6, 7, 52, 'Late', '2020-02-10 07:31:00', 'Notes'),
(48, 6, 7, 52, 'Late', '2020-02-11 10:51:38', 'Notes'),
(49, 3, 7, 52, 'Late', '2020-02-11 10:51:38', 'Late by 20 minutes from the sound of the bell. Lol Hahaha'),
(50, 5, 7, 52, 'Absent', '2020-02-11 10:51:38', 'Notes'),
(51, 8, 7, 52, 'Present', '2020-02-11 10:51:38', 'Notes'),
(52, 7, 7, 52, 'Absent', '2020-02-11 10:51:38', 'Notes'),
(53, 6, 7, 52, 'Absent', '2020-02-12 12:34:46', 'Notes'),
(54, 3, 7, 52, 'Absent', '2020-02-12 12:34:46', 'Gave excuse letter sent by parent.'),
(55, 5, 7, 52, 'Absent', '2020-02-12 12:34:46', 'Notes'),
(56, 8, 7, 52, 'Absent', '2020-02-12 12:34:46', 'Notes'),
(57, 7, 7, 52, 'Absent', '2020-02-12 12:34:46', 'Notes'),
(58, 6, 7, 52, 'Present', '2020-02-13 16:23:42', 'Notes'),
(59, 3, 7, 52, 'Present', '2020-02-13 16:23:42', 'Notes'),
(60, 5, 7, 52, 'Present', '2020-02-13 16:23:42', 'Notes'),
(61, 8, 7, 52, 'Absent', '2020-02-13 16:23:42', 'Notes'),
(62, 7, 7, 52, 'Present', '2020-02-13 16:23:42', 'Notes'),
(78, 1, 7, 52, 'Late', '2020-10-13 08:15:00', 'Trololol hahahaha'),
(79, 3, 7, 52, 'Present', '2020-10-13 08:15:00', 'Gave Excuse Letter'),
(80, 1, 7, 52, 'Present', '2020-10-12 17:39:55', ' '),
(81, 3, 7, 52, 'Late', '2020-10-12 17:39:55', 'Hay nako...Mata pud ug sayo oi..hahahaha');

-- --------------------------------------------------------

--
-- Table structure for table `bookissuedreturned`
--

CREATE TABLE `bookissuedreturned` (
  `id` int(11) NOT NULL,
  `sectionId` int(11) NOT NULL,
  `studentId` int(11) NOT NULL,
  `bookId` int(11) NOT NULL,
  `dateIssued` varchar(30) NOT NULL,
  `dateReturned` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `id` int(11) NOT NULL,
  `bookCode` varchar(30) NOT NULL,
  `bookName` varchar(500) NOT NULL DEFAULT 'Unnamed',
  `gradeLevel` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`id`, `bookCode`, `bookName`, `gradeLevel`) VALUES
(1, 'ENG32', 'English For You And Me 7', 7),
(2, 'MATH32', 'Mathematics in our Daily Lives', 8),
(3, 'FILIPINO-69', 'Wikang Sariling Atin', 7);

-- --------------------------------------------------------

--
-- Table structure for table `booktemplates`
--

CREATE TABLE `booktemplates` (
  `id` int(11) NOT NULL,
  `templateName` varchar(50) NOT NULL,
  `gradeLevel` int(11) NOT NULL,
  `booksContained` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `booktemplates`
--

INSERT INTO `booktemplates` (`id`, `templateName`, `gradeLevel`, `booksContained`) VALUES
(1, 'Grade 7 Template', 7, '1:3:');

-- --------------------------------------------------------

--
-- Table structure for table `enrollment`
--

CREATE TABLE `enrollment` (
  `id` int(11) NOT NULL,
  `studentId` int(11) NOT NULL,
  `sectionId` int(11) NOT NULL,
  `dateEnrolled` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `enrollment`
--

INSERT INTO `enrollment` (`id`, `studentId`, `sectionId`, `dateEnrolled`) VALUES
(5, 3, 7, '2019-11-10 21:28:46'),
(9, 1, 8, '2020-01-18 10:24:25'),
(15, 1, 10, '2020-02-12 13:27:51'),
(17, 1, 7, '2020-09-19 12:00:58');

-- --------------------------------------------------------

--
-- Table structure for table `grades`
--

CREATE TABLE `grades` (
  `id` int(11) NOT NULL,
  `studentId` int(11) NOT NULL,
  `sectionId` int(11) NOT NULL,
  `subjectId` int(11) NOT NULL,
  `firstQuarter` varchar(11) NOT NULL DEFAULT '-1',
  `secondQuarter` varchar(11) NOT NULL DEFAULT '-1',
  `thirdQuarter` varchar(11) NOT NULL DEFAULT '-1',
  `fourthQuarter` varchar(11) NOT NULL DEFAULT '-1',
  `gwa` varchar(11) NOT NULL DEFAULT '-1',
  `status` varchar(100) NOT NULL DEFAULT 'Open:Open:Open:Open:',
  `dateUpdated` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `grades`
--

INSERT INTO `grades` (`id`, `studentId`, `sectionId`, `subjectId`, `firstQuarter`, `secondQuarter`, `thirdQuarter`, `fourthQuarter`, `gwa`, `status`, `dateUpdated`) VALUES
(1, 6, 7, 11, '76', '78', '79', '77', '78', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(2, 3, 7, 11, '80', '90', '86', '89', '86', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(3, 5, 7, 11, '75', '80', '90', '95', '85', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(4, 6, 7, 8, '79', '76', '79', '78', '78', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(5, 3, 7, 8, '80', '80', '80', '76', '79', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(6, 5, 7, 8, '80', '90', '88', '89', '87', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(7, 6, 7, 14, '79', '78', '80', '79', '79', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(8, 6, 7, 17, '78', '78', '78', '81', '79', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(9, 6, 7, 10, '77', '75', '78', '78', '77', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(10, 6, 7, 13, '80', '80', '81', '78', '80', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(11, 6, 7, 16, '75', '77', '79', '79', '78', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(12, 6, 7, 18, '77', '77', '79', '83', '79', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(13, 6, 7, 9, '77', '77', '76', '77', '77', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(14, 6, 7, 12, '77', '78', '76', '77', '77', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(15, 6, 7, 15, '76', '77', '79', '80', '78', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(16, 6, 8, 19, '80', '90', '75', '80', '81', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(17, 6, 8, 23, '88', '79', '80', '85', '83', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(18, 6, 8, 26, '90', '82', '79', '90', '85', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(19, 6, 8, 29, '88', '77', '90', '85', '85', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(20, 6, 8, 20, '75', '80', '85', '90', '83', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(21, 6, 8, 21, '80', '80', '90', '93', '86', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(22, 6, 8, 24, '87', '86', '85', '90', '87', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(23, 6, 8, 28, '80', '80', '83', '84', '82', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(24, 6, 8, 22, '88', '89', '90', '94', '90', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(25, 6, 8, 25, '79', '86', '87', '96', '87', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(26, 6, 8, 27, '80', '86', '88', '95', '87', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(27, 6, 8, 53, '80', '0', '0', '0', '20', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(28, 8, 7, 8, '80', '69', '74', '99', '81', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(29, 9, 9, 8, '90', '90', '88', '96', '91', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(30, 9, 9, 11, '80', '85', '88', '90', '86', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(31, 9, 9, 15, '90', '87', '99', '76', '88', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(32, 9, 9, 18, '90', '80', '76', '88', '84', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(33, 9, 9, 52, '88', '89', '90', '91', '90', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(34, 9, 9, 10, '88', '89', '75', '78', '83', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(35, 9, 9, 12, '88', '89', '90', '88', '89', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(36, 9, 9, 14, '90', '78', '79', '88', '84', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(37, 9, 9, 16, '80', '89', '90', '95', '89', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(38, 9, 9, 9, '95', '80', '95', '98', '92', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(39, 9, 9, 13, '88', '96', '85', '89', '90', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(40, 9, 9, 17, '88', '89', '75', '89', '85', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(41, 7, 7, 8, '80', '80', '80', '80', '80', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(42, 8, 7, 10, '70', '70', '95', '95', '83', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(43, 3, 7, 10, '78', '88', '88', '88', '86', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(44, 5, 7, 10, '80', '80', '80', '85', '81', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(45, 7, 7, 10, '88', '78', '80', '79', '81', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(46, 8, 7, 11, '88', '87', '84', '81', '85', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(47, 7, 7, 11, '78', '77', '79', '90', '81', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(48, 7, 7, 14, '80', '80', '80', '88', '82', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(49, 5, 7, 14, '90', '86', '88', '81', '86', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(50, 3, 7, 14, '78', '88', '79', '86', '83', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(51, 8, 7, 14, '90', '91', '75', '99', '89', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(52, 7, 7, 17, '80', '80', '80', '80', '80', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(53, 5, 7, 17, '90', '90', '90', '90', '90', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(54, 3, 7, 17, '80', '80', '90', '85', '84', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(55, 8, 7, 17, '77', '79', '80', '87', '81', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(56, 7, 7, 9, '80', '90', '77', '88', '84', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(57, 5, 7, 9, '80', '88', '86', '78', '83', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(58, 3, 7, 9, '80', '90', '85', '90', '86', 'Submitted:Open:Open:Open:', '2020-10-20 10:59:03'),
(59, 8, 7, 9, '90', '80', '86', '84', '85', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(60, 7, 7, 12, '70', '78', '88', '86', '81', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(61, 5, 7, 12, '80', '88', '87', '87', '86', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(62, 3, 7, 12, '78', '79', '90', '96', '86', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(63, 8, 7, 12, '80', '96', '84', '87', '87', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(64, 7, 7, 16, '79', '78', '99', '76', '83', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(65, 5, 7, 16, '78', '79', '90', '78', '81', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(66, 3, 7, 16, '-1', '-1', '-1', '-1', '-1', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(67, 8, 7, 16, '-1', '-1', '-1', '-1', '-1', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(68, 7, 7, 18, '-1', '-1', '-1', '-1', '-1', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(69, 5, 7, 18, '-1', '-1', '-1', '-1', '-1', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(70, 3, 7, 18, '-1', '-1', '-1', '-1', '-1', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(71, 8, 7, 18, '-1', '-1', '-1', '-1', '-1', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(72, 7, 7, 13, '-1', '-1', '-1', '-1', '-1', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(73, 5, 7, 13, '-1', '-1', '-1', '-1', '-1', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(74, 3, 7, 13, '77', '77', '77', '77', '77', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(75, 8, 7, 13, '80', '-1', '-1', '-1', '20', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(76, 7, 7, 15, '-1', '-1', '-1', '-1', '-1', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(77, 5, 7, 15, '-1', '-1', '-1', '-1', '-1', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(78, 3, 7, 15, '-1', '-1', '-1', '-1', '-1', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(79, 8, 7, 15, '-1', '-1', '-1', '-1', '-1', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(80, 6, 10, 32, '90', '90', '90', '90', '90', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(81, 6, 10, 36, '80', '88', '89', '78', '84', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(82, 6, 10, 38, '80', '90', '88', '90', '87', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(83, 6, 10, 30, '80', '90', '88', '87', '86', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(84, 6, 10, 33, '80', '90', '87', '89', '87', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(85, 6, 10, 35, '80', '90', '80', '77', '82', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(86, 6, 10, 37, '80', '90', '77', '89', '84', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(87, 6, 10, 54, '99', '78', '80', '90', '87', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(88, 6, 10, 31, '80', '90', '78', '89', '84', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(89, 6, 10, 34, '80', '90', '87', '99', '89', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(90, 6, 10, 39, '88', '77', '99', '88', '88', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(91, 6, 10, 40, '90', '80', '90', '80', '85', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(92, 1, 8, 22, '99', '99', '99', '99', '99', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(93, 4, 8, 22, '-1', '-1', '-1', '-1', '-1', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(94, 1, 8, 27, '83', '-1', '-1', '-1', '21', 'Open:Open:Open:Open:', '2020-10-18 13:00:30'),
(95, 1, 7, 9, '80', '99', '89', '79', '86', 'Submitted:Submitted:Submitted:Submitted:', '2020-10-20 10:57:00');

-- --------------------------------------------------------

--
-- Table structure for table `loads`
--

CREATE TABLE `loads` (
  `a_id` int(11) NOT NULL,
  `b_loadName` varchar(200) NOT NULL,
  `c_gradeLevel` int(11) NOT NULL,
  `d_subjectsContained` varchar(500) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `loads`
--

INSERT INTO `loads` (`a_id`, `b_loadName`, `c_gradeLevel`, `d_subjectsContained`) VALUES
(8, 'Grade 7', 7, '8:9:10:11:12:13:14:15:16:17:18:52:60:'),
(9, 'Grade 8', 8, '19:20:21:22:23:24:25:26:27:28:29:61:53:'),
(10, 'Grade 9', 9, '30:31:32:33:34:35:36:37:38:39:40:62:54:'),
(11, 'Grade 10', 10, '41:42:43:44:45:46:47:48:49:50:51:63:55:'),
(12, 'Grade 8 New', 8, ''),
(13, 'Grade 8', 8, ''),
(14, 'Grade 10', 10, ''),
(15, 'Test Load', 7, '8:9:10:11:12:13:14:15:16:17:18:52:60:');

-- --------------------------------------------------------

--
-- Table structure for table `personalinfo`
--

CREATE TABLE `personalinfo` (
  `id` int(11) NOT NULL,
  `stdId` int(12) NOT NULL,
  `bDate` date NOT NULL,
  `age` int(11) NOT NULL DEFAULT '0',
  `bPlace` varchar(200) NOT NULL DEFAULT 'LOCATION',
  `mTongue` varchar(500) NOT NULL DEFAULT 'LANGUAGE',
  `ip` varchar(500) NOT NULL DEFAULT 'INDIGENOUS PEOPLE',
  `rlgn` varchar(500) NOT NULL DEFAULT 'RELIGION',
  `houseN` varchar(1000) NOT NULL DEFAULT 'HOUSE NUM',
  `brgy` varchar(200) NOT NULL DEFAULT 'BRGY',
  `mncpl` varchar(200) NOT NULL DEFAULT 'MUNICIPAL',
  `prvnce` varchar(200) NOT NULL DEFAULT 'PROVINCE',
  `fName` varchar(500) NOT NULL DEFAULT 'FATHER NAME',
  `mName` varchar(500) NOT NULL DEFAULT 'MOTHER NAME',
  `gName` varchar(500) DEFAULT 'GUARDIAN NAME',
  `rltnshp` varchar(100) NOT NULL DEFAULT 'RELATIONSHIP',
  `contact` varchar(20) NOT NULL DEFAULT 'CONTACT',
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `personalinfo`
--

INSERT INTO `personalinfo` (`id`, `stdId`, `bDate`, `age`, `bPlace`, `mTongue`, `ip`, `rlgn`, `houseN`, `brgy`, `mncpl`, `prvnce`, `fName`, `mName`, `gName`, `rltnshp`, `contact`, `date`) VALUES
(1, 1, '1999-03-01', 20, 'Manay, Davao Oriental', 'Mandaya', 'Mandaya', 'Roman Catholic', 'Purok 18, Bato St.', 'Central', 'Manay', 'Davao Oriental', 'Enrique C. Paderogao', 'Jocelyn E. Paderogao', 'Joerick E. Paderogao', 'Brother', '09483428056', '2020-10-21 19:31:33'),
(3, 2, '1999-03-01', 20, 'Manay, Davao Oriental', 'Mandaya', 'Mandaya', 'Roman Catholic', 'Purok 18, Bato St.', 'Central', 'Manay', 'Davao Oriental', 'Enrique C. Paderogao', 'Jocelyn E. Paderogao', 'Joerick E. Paderogao', 'Brother', '09483428056', '2020-09-09 18:37:23'),
(5, 3, '0000-00-00', 0, 'LOCATION', 'LANGUAGE', 'INDIGENOUS PEOPLE', 'RELIGION', 'HOUSE NUM', 'BRGY', 'MUNICIPAL', 'PROVINCE', 'FATHER NAME', 'MOTHER NAME', 'GUARDIAN NAME', 'RELATIONSHIP', 'CONTACT', '2020-09-05 17:05:12');

-- --------------------------------------------------------

--
-- Table structure for table `sections`
--

CREATE TABLE `sections` (
  `id` int(11) NOT NULL,
  `sectionName` varchar(50) NOT NULL,
  `adviserId` int(11) NOT NULL,
  `loadId` int(11) NOT NULL,
  `bookTemplateId` int(11) NOT NULL DEFAULT '-1',
  `schoolYear` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sections`
--

INSERT INTO `sections` (`id`, `sectionName`, `adviserId`, `loadId`, `bookTemplateId`, `schoolYear`) VALUES
(7, 'Grade 7 - Fidelity', 2, 8, 1, 2019),
(8, 'Grade 8 - Cashew', 2, 9, -1, 2020),
(9, 'Grade 7 Rizal', 1, 8, -1, 2020),
(10, 'Grade 9 - Mabini', 2, 10, -1, 2020),
(11, 'Grade 10 - Strawberry', 3, 11, -1, 2019),
(12, 'Grade 9 - Integrity', 3, 8, -1, 2019),
(13, 'Grade 10 - Unity', 2, 11, -1, 2019),
(14, 'Grade 7 Oreo', 7, 8, -1, 2019),
(15, 'Grade 9 - Nikko', 8, 10, -1, 2019),
(16, 'Grade 8 - Paderogao', 2, 12, -1, 2020);

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `id` int(11) NOT NULL,
  `lrn` varchar(12) NOT NULL,
  `lName` varchar(100) NOT NULL,
  `fName` varchar(100) NOT NULL,
  `mName` varchar(100) NOT NULL,
  `sex` varchar(10) NOT NULL,
  `inGr` float NOT NULL,
  `curGrLvl` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`id`, `lrn`, `lName`, `fName`, `mName`, `sex`, `inGr`, `curGrLvl`) VALUES
(1, '123543457474', 'Paderogao', 'Phil Rey', 'Estrella', 'Male', 90.1, 7),
(2, '123456789012', 'Kerby', 'Estrella', 'Paderogao', 'Female', 90.2, 0),
(3, '123456789023', 'Rizal', 'Jose', 'Protacio', 'Male', 99, 0);

-- --------------------------------------------------------

--
-- Table structure for table `subjects`
--

CREATE TABLE `subjects` (
  `id` int(11) NOT NULL,
  `subjectCode` varchar(200) NOT NULL,
  `description` varchar(500) NOT NULL,
  `gradeLevel` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subjects`
--

INSERT INTO `subjects` (`id`, `subjectCode`, `description`, `gradeLevel`) VALUES
(8, 'FIL7', 'Filipino 7', 7),
(9, 'ENG7', 'English 7', 7),
(10, 'MATH7', 'Mathematics 7', 7),
(11, 'SCI7', 'Science 7', 7),
(12, 'AP7', 'Araling Panlipunan 7', 7),
(13, 'ESP7', 'Edukasyon sa Pagpapakatao 7', 7),
(14, 'TLE7', 'Technology and Livelihood Education 7', 7),
(15, 'MUS7', 'Music 7', 7),
(16, 'ART7', 'Arts 7', 7),
(17, 'PE7', 'Physical Education 7', 7),
(18, 'HLT7', 'Health 7', 7),
(19, 'FIL8', 'Filipino 8', 8),
(20, 'ENG8', 'English 8', 8),
(21, 'MATH8', 'Mathematics 8', 8),
(22, 'SCI8', 'Science 8', 8),
(23, 'AP8', 'Araling Panlipunan 8', 8),
(24, 'ESP8', 'Edukasyon sa Pagpapakatao 8', 8),
(25, 'TLE8', 'Technology and Livelihood Education', 8),
(26, 'MUS8', 'Music 8', 8),
(27, 'ART8', 'Arts 8', 8),
(28, 'PE8', 'Physical Education 8', 8),
(29, 'HLT8', 'Health 8', 8),
(30, 'FIL9', 'Filipino 9', 9),
(31, 'ENG9', 'English 9', 9),
(32, 'MATH9', 'Mathematics 9', 9),
(33, 'SCI9', 'Science 9', 9),
(34, 'AP9', 'Araling Panlipunan 9', 9),
(35, 'ESP9', 'Edukasyon sa Pagpapakatao 9', 9),
(36, 'TLE9', 'Technology and Livelihood Education 9', 9),
(37, 'MUS9', 'Music 9', 9),
(38, 'ART9', 'Arts 9', 9),
(39, 'PE9', 'Physical Education 9', 9),
(40, 'HLT9', 'Health 9', 9),
(41, 'FIL10', 'Filipino 10', 10),
(42, 'ENG10', 'English 10', 10),
(43, 'MATH10', 'Mathematics 10', 10),
(44, 'SCI10', 'Science 10', 10),
(45, 'AP10', 'Araling Panlipunan 10', 10),
(46, 'ESP10', 'Edukasyon sa Pagpapakatao 10', 10),
(47, 'TLE10', 'Technology and Livelihood Education 10', 10),
(48, 'MUS10', 'Music 10', 10),
(49, 'ART10', 'Arts 10', 10),
(50, 'PE10', 'Physical Education 10', 10),
(51, 'HLT10', 'Health 10', 10),
(52, 'ADV7', 'Advisory 7', 7),
(53, 'ADV8', 'Advisory 8', 8),
(54, 'ADV9', 'Advisory 9', 9),
(55, 'ADV10', 'Advisory 10', 10),
(56, 'IT410', 'IT Practicum 2', 7),
(57, 'span8', 'Spanish 8', 8),
(58, 'it 411', ';lksdfbvhnlkajsfbg', 7),
(59, 'ANIM7', 'Animation 7', 7),
(60, 'MPH7', 'MAPEH 7', 7),
(61, 'MPH8', 'MAPEH 8', 8),
(62, 'MPH9', 'MAPEH 9', 9),
(63, 'MPH10', 'MAPEH 10', 10);

-- --------------------------------------------------------

--
-- Table structure for table `teacherloads`
--

CREATE TABLE `teacherloads` (
  `id` int(11) NOT NULL,
  `sectionId` int(11) NOT NULL,
  `teacherId` int(11) NOT NULL,
  `subjectId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `teacherloads`
--

INSERT INTO `teacherloads` (`id`, `sectionId`, `teacherId`, `subjectId`) VALUES
(1, 7, 3, 9),
(2, 9, 2, 8),
(3, 9, 3, 9),
(4, 9, 4, 10),
(5, 9, 5, 11),
(6, 9, 7, 12),
(7, 9, 8, 13),
(8, 9, 7, 14),
(9, 9, 10, 15),
(10, 9, 11, 16),
(11, 9, 8, 17),
(12, 9, 4, 18),
(13, 9, 1, 52),
(14, 8, -1, 19),
(15, 8, -1, 20),
(16, 8, -1, 21),
(17, 8, -1, 22),
(18, 8, -1, 23),
(19, 8, -1, 24),
(20, 8, -1, 25),
(21, 8, -1, 26),
(22, 8, -1, 27),
(23, 8, -1, 28),
(24, 8, -1, 29),
(25, 8, 2, 53),
(26, 10, -1, 30),
(27, 10, -1, 31),
(28, 10, -1, 32),
(29, 10, -1, 33),
(30, 10, -1, 34),
(31, 10, -1, 35),
(32, 10, -1, 36),
(33, 10, -1, 37),
(34, 10, -1, 38),
(35, 10, -1, 39),
(36, 10, -1, 40),
(37, 10, 2, 54),
(38, 11, -1, 41),
(39, 11, -1, 42),
(40, 11, -1, 43),
(41, 11, -1, 44),
(42, 11, -1, 45),
(43, 11, -1, 46),
(44, 11, -1, 47),
(45, 11, -1, 48),
(46, 11, -1, 49),
(47, 11, -1, 50),
(48, 11, -1, 51),
(49, 11, -1, 55),
(50, 13, -1, 41),
(51, 13, -1, 42),
(52, 13, -1, 43),
(53, 13, -1, 44),
(54, 13, -1, 45),
(55, 13, -1, 46),
(56, 13, -1, 47),
(57, 13, -1, 48),
(58, 13, -1, 49),
(59, 13, -1, 50),
(60, 13, -1, 51),
(61, 13, -1, 55),
(62, 7, -1, 8),
(63, 7, -1, 10),
(64, 7, -1, 11),
(65, 7, -1, 12),
(66, 7, -1, 13),
(67, 7, -1, 14),
(68, 7, -1, 15),
(69, 7, -1, 16),
(70, 7, -1, 17),
(71, 7, -1, 18),
(72, 7, 2, 52),
(73, 9, -1, 60),
(86, 8, -1, 61),
(99, 10, -1, 62),
(112, 7, -1, 60),
(125, 14, -1, 8),
(126, 14, -1, 9),
(127, 14, -1, 10),
(128, 14, -1, 11),
(129, 14, -1, 12),
(130, 14, -1, 13),
(131, 14, -1, 14),
(132, 14, -1, 15),
(133, 14, -1, 16),
(134, 14, -1, 17),
(135, 14, -1, 18),
(136, 14, -1, 60),
(137, 14, -1, 52);

-- --------------------------------------------------------

--
-- Table structure for table `userdetails`
--

CREATE TABLE `userdetails` (
  `id` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `employeeNumber` varchar(100) NOT NULL DEFAULT 'TIN NUMBER',
  `fundSource` varchar(1000) NOT NULL DEFAULT 'FUND SOURCE',
  `position` varchar(1000) NOT NULL DEFAULT 'POSITION',
  `nature` varchar(1000) NOT NULL DEFAULT 'NATURE',
  `degree` varchar(1000) NOT NULL DEFAULT 'DEGREE',
  `major` varchar(1000) NOT NULL DEFAULT 'MAJOR',
  `minor` varchar(1000) NOT NULL DEFAULT 'MINOR',
  `managedSubjects` varchar(10000) NOT NULL DEFAULT 'NONE'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userdetails`
--

INSERT INTO `userdetails` (`id`, `userId`, `employeeNumber`, `fundSource`, `position`, `nature`, `degree`, `major`, `minor`, `managedSubjects`) VALUES
(3, 1, 'emp', 'Fund', 'Pos', 'Nature\'s Spring Davao Branch', 'Deg', 'Majo', 'Min', '8:9:'),
(4, 2, ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'NONE'),
(5, 5, '12313153463', 'Fund Source', 'Master Teacher IV', 'Spring', 'BED', 'FILIPINO', 'ENGLISH', '8:19:30:41:'),
(6, 3, ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'NONE'),
(7, 4, ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'NONE'),
(8, 6, ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'NONE'),
(9, 7, '12315346-12312313', 'Funds', 'Master Teacher V', 'Nature', 'BEED', 'English', 'Filipino', 'NONE'),
(10, 8, ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'NONE'),
(11, 9, '32165465', 'FSDFG', 'FDFG', 'VXCV', 'XCVA', 'ASZ', 'ZXCZSD', '9:20:31:42:'),
(13, 10, 'TIN NUMBER', 'FUND SOURCE', 'POSITION', 'NATURE', 'DEGREE', 'MAJOR', 'MINOR', 'NONE');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `user_Lname` varchar(200) NOT NULL,
  `user_Fname` varchar(200) NOT NULL,
  `user_Mname` varchar(200) NOT NULL,
  `gender` varchar(12) NOT NULL,
  `user_name` varchar(200) NOT NULL,
  `user_password` varchar(200) NOT NULL,
  `user_level` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `user_Lname`, `user_Fname`, `user_Mname`, `gender`, `user_name`, `user_password`, `user_level`) VALUES
(1, 'Paderogao', 'Phil Rey', 'Estrella', 'Male', 'admin', 'password', 5),
(2, 'Furahashi', 'Fumino', 'Ona', 'Female', 'benkyu', 'password', 1),
(3, 'Paderogao', 'Kerby', 'Estrella', 'Female', 'kerbs', 'pass', 1),
(4, 'Dela Cruz', 'Juan', 'Ponciano', 'Male', 'registrar', 'password', 4),
(5, 'Rizal', 'Jose', 'Protacio', 'Male', 'depheadfil7', 'password', 2),
(6, 'Ramsey', 'Gordon', 'Grant', 'Male', 'currhead', 'password', 3),
(7, 'Sins', 'Jhonny', 'Marcus', 'Male', 'john', 'password', 4),
(8, 'Bulahan', 'Harris', 'Kay', 'Male', 'hbulahan', 'password1', 3),
(9, 'Rezane', 'Warren', 'Dunno', 'Male', 'wrezxaneDH', '1234567', 2),
(10, 'Lname', 'Fname', 'Mname', 'Female', 'admin2', 'password', 3),
(11, 'Lname2', 'Fname2', 'Mname2', 'Female', 'admin3', 'password', 2);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_enrollment`
-- (See below for the actual view)
--
CREATE TABLE `v_enrollment` (
`id` int(11)
,`studentId` int(11)
,`lrn` varchar(12)
,`lName` varchar(100)
,`fName` varchar(100)
,`mName` varchar(100)
,`sex` varchar(10)
,`sectionId` int(11)
,`sectionName` varchar(50)
,`adviserId` int(11)
,`user_Lname` varchar(200)
,`user_Fname` varchar(200)
,`user_Mname` varchar(200)
,`loadId` int(11)
,`b_loadName` varchar(200)
,`c_gradeLevel` int(11)
,`schoolYear` int(11)
,`dateEnrolled` datetime
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_enrollment_minimal`
-- (See below for the actual view)
--
CREATE TABLE `v_enrollment_minimal` (
`id` int(11)
,`studentId` int(11)
,`lrn` varchar(12)
,`lName` varchar(100)
,`fName` varchar(100)
,`mName` varchar(100)
,`sex` varchar(10)
,`sectionId` int(11)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_managedsubjects`
-- (See below for the actual view)
--
CREATE TABLE `v_managedsubjects` (
`id` int(11)
,`sectionId` int(11)
,`sectionName` varchar(50)
,`teacherId` int(11)
,`user_Lname` varchar(200)
,`user_Fname` varchar(200)
,`user_Mname` varchar(200)
,`gender` varchar(12)
,`subjectId` int(11)
,`subjectCode` varchar(200)
,`description` varchar(500)
,`gradeLevel` int(11)
,`schoolYear` int(11)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_managedsubjects_wbooktemplate`
-- (See below for the actual view)
--
CREATE TABLE `v_managedsubjects_wbooktemplate` (
`id` int(11)
,`sectionId` int(11)
,`sectionName` varchar(50)
,`teacherId` int(11)
,`user_Lname` varchar(200)
,`user_Fname` varchar(200)
,`user_Mname` varchar(200)
,`gender` varchar(12)
,`subjectId` int(11)
,`subjectCode` varchar(200)
,`description` varchar(500)
,`gradeLevel` int(11)
,`schoolYear` int(11)
,`bookTemplateId` int(11)
,`templateName` varchar(50)
,`booksContained` varchar(500)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_sections`
-- (See below for the actual view)
--
CREATE TABLE `v_sections` (
`id` int(11)
,`sectionName` varchar(50)
,`adviserId` int(11)
,`user_Lname` varchar(200)
,`user_Fname` varchar(200)
,`user_Mname` varchar(200)
,`gender` varchar(12)
,`loadId` int(11)
,`b_loadName` varchar(200)
,`c_gradeLevel` int(11)
,`schoolYear` int(11)
,`d_subjectsContained` varchar(500)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_teacherloads`
-- (See below for the actual view)
--
CREATE TABLE `v_teacherloads` (
`id` int(11)
,`sectionId` int(11)
,`teacherId` int(11)
,`user_Lname` varchar(200)
,`user_Fname` varchar(200)
,`user_Mname` varchar(200)
,`gender` varchar(12)
,`subjectId` int(11)
,`subjectCode` varchar(200)
,`description` varchar(500)
,`gradeLevel` int(11)
);

-- --------------------------------------------------------

--
-- Structure for view `v_enrollment`
--
DROP TABLE IF EXISTS `v_enrollment`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_enrollment`  AS  select `enrollment`.`id` AS `id`,`enrollment`.`studentId` AS `studentId`,`students`.`lrn` AS `lrn`,`students`.`lName` AS `lName`,`students`.`fName` AS `fName`,`students`.`mName` AS `mName`,`students`.`sex` AS `sex`,`enrollment`.`sectionId` AS `sectionId`,`sections`.`sectionName` AS `sectionName`,`sections`.`adviserId` AS `adviserId`,`users`.`user_Lname` AS `user_Lname`,`users`.`user_Fname` AS `user_Fname`,`users`.`user_Mname` AS `user_Mname`,`sections`.`loadId` AS `loadId`,`loads`.`b_loadName` AS `b_loadName`,`loads`.`c_gradeLevel` AS `c_gradeLevel`,`sections`.`schoolYear` AS `schoolYear`,`enrollment`.`dateEnrolled` AS `dateEnrolled` from ((((`enrollment` left join `students` on((`enrollment`.`studentId` = `students`.`id`))) left join `sections` on((`enrollment`.`sectionId` = `sections`.`id`))) left join `users` on((`sections`.`adviserId` = `users`.`id`))) left join `loads` on((`sections`.`loadId` = `loads`.`a_id`))) ;

-- --------------------------------------------------------

--
-- Structure for view `v_enrollment_minimal`
--
DROP TABLE IF EXISTS `v_enrollment_minimal`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_enrollment_minimal`  AS  select `enrollment`.`id` AS `id`,`enrollment`.`studentId` AS `studentId`,`students`.`lrn` AS `lrn`,`students`.`lName` AS `lName`,`students`.`fName` AS `fName`,`students`.`mName` AS `mName`,`students`.`sex` AS `sex`,`enrollment`.`sectionId` AS `sectionId` from (`enrollment` left join `students` on((`enrollment`.`studentId` = `students`.`id`))) order by `enrollment`.`sectionId` desc,`students`.`sex` desc,`students`.`lName`,`students`.`fName`,`students`.`mName` ;

-- --------------------------------------------------------

--
-- Structure for view `v_managedsubjects`
--
DROP TABLE IF EXISTS `v_managedsubjects`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_managedsubjects`  AS  select `teacherloads`.`id` AS `id`,`teacherloads`.`sectionId` AS `sectionId`,`sections`.`sectionName` AS `sectionName`,`teacherloads`.`teacherId` AS `teacherId`,ifnull(`users`.`user_Lname`,'None') AS `user_Lname`,ifnull(`users`.`user_Fname`,'None') AS `user_Fname`,ifnull(`users`.`user_Mname`,'None') AS `user_Mname`,ifnull(`users`.`gender`,'None') AS `gender`,`teacherloads`.`subjectId` AS `subjectId`,`subjects`.`subjectCode` AS `subjectCode`,`subjects`.`description` AS `description`,`subjects`.`gradeLevel` AS `gradeLevel`,`sections`.`schoolYear` AS `schoolYear` from (((`teacherloads` left join `sections` on((`teacherloads`.`sectionId` = `sections`.`id`))) left join `users` on((`teacherloads`.`teacherId` = `users`.`id`))) left join `subjects` on((`teacherloads`.`subjectId` = `subjects`.`id`))) order by `sections`.`schoolYear` desc,`subjects`.`gradeLevel`,`sections`.`sectionName`,`users`.`user_Lname`,`users`.`user_Fname` ;

-- --------------------------------------------------------

--
-- Structure for view `v_managedsubjects_wbooktemplate`
--
DROP TABLE IF EXISTS `v_managedsubjects_wbooktemplate`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_managedsubjects_wbooktemplate`  AS  select `teacherloads`.`id` AS `id`,`teacherloads`.`sectionId` AS `sectionId`,`sections`.`sectionName` AS `sectionName`,`teacherloads`.`teacherId` AS `teacherId`,ifnull(`users`.`user_Lname`,'None') AS `user_Lname`,ifnull(`users`.`user_Fname`,'None') AS `user_Fname`,ifnull(`users`.`user_Mname`,'None') AS `user_Mname`,ifnull(`users`.`gender`,'None') AS `gender`,`teacherloads`.`subjectId` AS `subjectId`,`subjects`.`subjectCode` AS `subjectCode`,`subjects`.`description` AS `description`,`subjects`.`gradeLevel` AS `gradeLevel`,`sections`.`schoolYear` AS `schoolYear`,`sections`.`bookTemplateId` AS `bookTemplateId`,ifnull(`booktemplates`.`templateName`,'None') AS `templateName`,ifnull(`booktemplates`.`booksContained`,'None') AS `booksContained` from ((((`teacherloads` left join `sections` on((`teacherloads`.`sectionId` = `sections`.`id`))) left join `users` on((`teacherloads`.`teacherId` = `users`.`id`))) left join `subjects` on((`teacherloads`.`subjectId` = `subjects`.`id`))) left join `booktemplates` on((`sections`.`bookTemplateId` = `booktemplates`.`id`))) order by `sections`.`schoolYear` desc,`subjects`.`gradeLevel`,`sections`.`sectionName`,`users`.`user_Lname`,`users`.`user_Fname` ;

-- --------------------------------------------------------

--
-- Structure for view `v_sections`
--
DROP TABLE IF EXISTS `v_sections`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_sections`  AS  select `sections`.`id` AS `id`,`sections`.`sectionName` AS `sectionName`,`sections`.`adviserId` AS `adviserId`,`users`.`user_Lname` AS `user_Lname`,`users`.`user_Fname` AS `user_Fname`,`users`.`user_Mname` AS `user_Mname`,`users`.`gender` AS `gender`,`sections`.`loadId` AS `loadId`,`loads`.`b_loadName` AS `b_loadName`,`loads`.`c_gradeLevel` AS `c_gradeLevel`,`sections`.`schoolYear` AS `schoolYear`,`loads`.`d_subjectsContained` AS `d_subjectsContained` from ((`sections` left join `users` on((`sections`.`adviserId` = `users`.`id`))) left join `loads` on((`sections`.`loadId` = `loads`.`a_id`))) order by `sections`.`schoolYear` desc,`loads`.`c_gradeLevel`,`sections`.`sectionName` ;

-- --------------------------------------------------------

--
-- Structure for view `v_teacherloads`
--
DROP TABLE IF EXISTS `v_teacherloads`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_teacherloads`  AS  select `teacherloads`.`id` AS `id`,`teacherloads`.`sectionId` AS `sectionId`,`teacherloads`.`teacherId` AS `teacherId`,ifnull(`users`.`user_Lname`,'None') AS `user_Lname`,ifnull(`users`.`user_Fname`,'None') AS `user_Fname`,ifnull(`users`.`user_Mname`,'None') AS `user_Mname`,ifnull(`users`.`gender`,'None') AS `gender`,`teacherloads`.`subjectId` AS `subjectId`,`subjects`.`subjectCode` AS `subjectCode`,`subjects`.`description` AS `description`,`subjects`.`gradeLevel` AS `gradeLevel` from ((`teacherloads` left join `users` on((`teacherloads`.`teacherId` = `users`.`id`))) left join `subjects` on((`teacherloads`.`subjectId` = `subjects`.`id`))) ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `attendance`
--
ALTER TABLE `attendance`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `bookissuedreturned`
--
ALTER TABLE `bookissuedreturned`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `booktemplates`
--
ALTER TABLE `booktemplates`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `enrollment`
--
ALTER TABLE `enrollment`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `grades`
--
ALTER TABLE `grades`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `loads`
--
ALTER TABLE `loads`
  ADD PRIMARY KEY (`a_id`);

--
-- Indexes for table `personalinfo`
--
ALTER TABLE `personalinfo`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sections`
--
ALTER TABLE `sections`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `subjects`
--
ALTER TABLE `subjects`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `teacherloads`
--
ALTER TABLE `teacherloads`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `userdetails`
--
ALTER TABLE `userdetails`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `attendance`
--
ALTER TABLE `attendance`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=82;

--
-- AUTO_INCREMENT for table `bookissuedreturned`
--
ALTER TABLE `bookissuedreturned`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `books`
--
ALTER TABLE `books`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `booktemplates`
--
ALTER TABLE `booktemplates`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `enrollment`
--
ALTER TABLE `enrollment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `grades`
--
ALTER TABLE `grades`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=96;

--
-- AUTO_INCREMENT for table `loads`
--
ALTER TABLE `loads`
  MODIFY `a_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `personalinfo`
--
ALTER TABLE `personalinfo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `sections`
--
ALTER TABLE `sections`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `subjects`
--
ALTER TABLE `subjects`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=64;

--
-- AUTO_INCREMENT for table `teacherloads`
--
ALTER TABLE `teacherloads`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=138;

--
-- AUTO_INCREMENT for table `userdetails`
--
ALTER TABLE `userdetails`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
