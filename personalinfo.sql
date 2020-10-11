-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 12, 2020 at 08:56 AM
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
-- Database: `cbnhs_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `personalinfo`
--

CREATE TABLE `personalinfo` (
  `id` int(11) NOT NULL,
  `student_lrn` varchar(200) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `birthDate` date NOT NULL,
  `age` int(11) NOT NULL,
  `birthPlace` varchar(200) NOT NULL,
  `mTongue` varchar(500) NOT NULL,
  `ip` varchar(500) NOT NULL,
  `religion` varchar(500) NOT NULL,
  `houseN` varchar(1000) NOT NULL,
  `brgy` varchar(200) NOT NULL,
  `municipal` varchar(200) NOT NULL,
  `province` varchar(200) NOT NULL,
  `fathersName` varchar(500) NOT NULL,
  `mothersName` varchar(500) NOT NULL,
  `guardiansName` varchar(500) DEFAULT NULL,
  `relationship` varchar(100) NOT NULL,
  `contactNumber` varchar(20) NOT NULL,
  `remarks` varchar(100) NOT NULL,
  `dateAdded` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `personalinfo`
--

INSERT INTO `personalinfo` (`id`, `student_lrn`, `gender`, `birthDate`, `age`, `birthPlace`, `mTongue`, `ip`, `religion`, `houseN`, `brgy`, `municipal`, `province`, `fathersName`, `mothersName`, `guardiansName`, `relationship`, `contactNumber`, `remarks`, `dateAdded`) VALUES
(1, '2015-2100101', 'M', '1999-03-01', 20, 'Manay, Davao Oriental', 'Mandaya', 'Mandaya', 'Roman Catholic', 'Purok 18, Bato St.', 'Central', 'Manay', 'Davao Oriental', 'Enrique C. Paderogao', 'Jocelyn E. Paderogao', 'Joerick E. Paderogao', 'Brother', '09483428056', 'TRANSFERRED IN', '2020-02-03 20:28:47'),
(2, '2015-21003', 'F', '2005-08-07', 20, 'TBD', 'Japanese', 'TBD', 'TBD', 'TBD', 'TBD', 'TBD', 'TBD', 'TBD', 'TBD', 'TBD', 'TBD', 'TBD', ' ', '2020-02-03 22:06:56'),
(3, '2015-21002', 'F', '1999-03-05', 20, 'Davao City', 'TBD', 'TBD', 'TBD', 'TBD', 'TBD', 'TBD', 'TBD', 'TBD', 'TBD', 'TBD', 'TBD', 'TBD', 'TBD', '2020-01-31 15:11:49'),
(4, '2015-21006', 'F', '2000-08-07', 17, 'BP', 'MT', 'IP', 'RLGN', 'A1', 'A2', 'A3', 'A4', 'FN', 'MN', 'GN', 'RLTNSHP', 'CN', 'DROPPED E1', '2019-10-10 09:30:02'),
(5, '124578951422', 'M', '2007-05-23', 25, 'Manay, Davao Oriental', 'Mandaya', 'Mandaya Lan', 'Roman Catholic', 'Purok 18', 'Central', 'Manay', 'Davao Oriental', 'Enrique C. Paderogao', 'Jocelyn C. Estrella', 'Joerick E. Paderogao', 'Brother', '09199578891', 'DROPPED D3', '2020-01-14 12:50:29'),
(6, '2015-11009', 'F', '0000-00-00', 0, ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' TRANSFERRED IN', '2020-02-03 20:39:01'),
(7, '102049102', 'M', '1998-08-21', 100, 'Davao', 'Chinese ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'TRANSFERRED OUT', '2020-02-04 13:47:18'),
(8, '012345678910', 'F', '1999-03-01', 21, 'Davao City', 'Mandaya', 'Mandaya', 'Roman Catholic', 'Purok 18', 'Central', 'Manay', 'Davao', 'Enrique C. Paderogao', 'Jocelyn E. Paderogao', 'NA', 'NA', '09080803542', ' ', '2020-02-07 14:38:50'),
(9, '123455456780', 'M', '0000-00-00', 0, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '2020-02-11 09:29:37'),
(10, '123456789013', 'M', '0000-00-00', 0, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '2020-02-11 10:09:20'),
(11, '123456789012', 'M', '1999-03-01', 20, ' ', ' Cebuano', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' DROPPED E1', '2020-02-14 10:03:06'),
(12, '854751245978', 'M', '1996-11-04', 23, 'Davao city', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '2020-02-14 14:19:44'),
(13, '123456789088', 'F', '0000-00-00', 0, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '2020-03-06 16:07:01'),
(14, '451785963214', 'M', '1996-02-14', 23, 'degfasfg', 'sf', 'asfg', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '2020-03-06 16:12:52');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `personalinfo`
--
ALTER TABLE `personalinfo`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `personalinfo`
--
ALTER TABLE `personalinfo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
