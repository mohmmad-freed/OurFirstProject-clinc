-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 07 مايو 2023 الساعة 00:18
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
-- بنية الجدول `dates`
--

CREATE TABLE `dates` (
  `DoID` int(11) NOT NULL,
  `SeID` int(11) NOT NULL,
  `PaID` int(11) NOT NULL,
  `Date` date NOT NULL,
  `Time` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- بنية الجدول `doctor`
--

CREATE TABLE `doctor` (
  `DoID` int(9) NOT NULL,
  `DoName` varchar(30) NOT NULL,
  `DoPhone` varchar(14) NOT NULL,
  `DoEmail` varchar(40) NOT NULL,
  `DoPass` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- إرجاع أو استيراد بيانات الجدول `doctor`
--

INSERT INTO `doctor` (`DoID`, `DoName`, `DoPhone`, `DoEmail`, `DoPass`) VALUES
(37, 'mohammad Fareed', '0598227364', 'mbdalmnm05@gmail.com', '1235789');

-- --------------------------------------------------------

--
-- بنية الجدول `patients`
--

CREATE TABLE `patients` (
  `PaID` int(11) NOT NULL,
  `PaName` varchar(14) NOT NULL,
  `PaPhone` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- بنية الجدول `schedule`
--

CREATE TABLE `schedule` (
  `DoID` int(11) NOT NULL,
  `day` varchar(10) NOT NULL,
  `DTime` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- بنية الجدول `secrtary`
--

CREATE TABLE `secrtary` (
  `SeID` int(11) NOT NULL,
  `SeName` varchar(30) NOT NULL,
  `SePhone` varchar(14) NOT NULL,
  `SeEmail` varchar(40) NOT NULL,
  `SePass` varchar(20) NOT NULL
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
-- Indexes for table `dates`
--
ALTER TABLE `dates`
  ADD PRIMARY KEY (`DoID`,`Date`,`Time`) USING BTREE,
  ADD KEY `1` (`DoID`,`SeID`,`PaID`) USING BTREE,
  ADD KEY `SeID` (`SeID`),
  ADD KEY `PaID` (`PaID`);

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`DoID`);

--
-- Indexes for table `patients`
--
ALTER TABLE `patients`
  ADD PRIMARY KEY (`PaID`),
  ADD UNIQUE KEY `PaPhone` (`PaPhone`);

--
-- Indexes for table `schedule`
--
ALTER TABLE `schedule`
  ADD KEY `DoID` (`DoID`);

--
-- Indexes for table `secrtary`
--
ALTER TABLE `secrtary`
  ADD PRIMARY KEY (`SeID`);

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
-- AUTO_INCREMENT for table `doctor`
--
ALTER TABLE `doctor`
  MODIFY `DoID` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT for table `patients`
--
ALTER TABLE `patients`
  MODIFY `PaID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `secrtary`
--
ALTER TABLE `secrtary`
  MODIFY `SeID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- قيود الجداول المُلقاة.
--

--
-- قيود الجداول `dates`
--
ALTER TABLE `dates`
  ADD CONSTRAINT `dates_ibfk_1` FOREIGN KEY (`SeID`) REFERENCES `secrtary` (`SeID`) ON UPDATE CASCADE,
  ADD CONSTRAINT `dates_ibfk_2` FOREIGN KEY (`DoID`) REFERENCES `doctor` (`DoID`) ON UPDATE CASCADE,
  ADD CONSTRAINT `dates_ibfk_3` FOREIGN KEY (`PaID`) REFERENCES `patients` (`PaID`) ON UPDATE CASCADE;

--
-- قيود الجداول `schedule`
--
ALTER TABLE `schedule`
  ADD CONSTRAINT `schedule_ibfk_1` FOREIGN KEY (`DoID`) REFERENCES `doctor` (`DoID`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
