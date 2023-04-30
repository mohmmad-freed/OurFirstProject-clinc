-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 30 أبريل 2023 الساعة 03:39
-- إصدار الخادم: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `maindb`
--
CREATE DATABASE IF NOT EXISTS `maindb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `maindb`;

-- --------------------------------------------------------

--
-- بنية الجدول `doctordefaultdates`
--

CREATE TABLE `doctordefaultdates` (
  `id` int(11) NOT NULL,
  `day` varchar(10) NOT NULL,
  `from` time DEFAULT NULL,
  `to` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- إرجاع أو استيراد بيانات الجدول `doctordefaultdates`
--

INSERT INTO `doctordefaultdates` (`id`, `day`, `from`, `to`) VALUES
(1, 'Sunday', NULL, NULL),
(2, 'Monday', NULL, NULL),
(3, 'Tuesday', NULL, NULL),
(4, 'Wednesday', NULL, NULL),
(5, 'Thursday', NULL, NULL),
(6, 'Friday', NULL, NULL),
(7, 'Saturday', NULL, NULL);

-- --------------------------------------------------------

--
-- بنية الجدول `patients`
--

CREATE TABLE `patients` (
  `ID` int(11) NOT NULL,
  `Name` varchar(40) NOT NULL,
  `Phone` varchar(10) NOT NULL,
  `Balance` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- بنية الجدول `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `fullName` varchar(85) NOT NULL,
  `mobile` char(10) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` set('admin','coAdmin','Sec','Doctor') NOT NULL DEFAULT 'admin'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- إرجاع أو استيراد بيانات الجدول `users`
--

INSERT INTO `users` (`id`, `fullName`, `mobile`, `password`, `role`) VALUES
(1, 'mohammadFareed', '0568727202', '12357890', 'admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `doctordefaultdates`
--
ALTER TABLE `doctordefaultdates`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `patients`
--
ALTER TABLE `patients`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `users_mobile_unique` (`mobile`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `doctordefaultdates`
--
ALTER TABLE `doctordefaultdates`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `patients`
--
ALTER TABLE `patients`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
