-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 20, 2020 at 05:09 AM
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

--
-- Indexes for dumped tables
--

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
