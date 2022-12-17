-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 17, 2022 at 06:09 AM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bdlocationvoiture`
--

-- --------------------------------------------------------

--
-- Table structure for table `locations`
--

CREATE TABLE `locations` (
  `idl` int(10) NOT NULL,
  `client` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `voiture` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `dated` date NOT NULL,
  `datef` date NOT NULL,
  `days` int(10) NOT NULL,
  `cout` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `locations`
--

INSERT INTO `locations` (`idl`, `client`, `voiture`, `dated`, `datef`, `days`, `cout`) VALUES
(1, 'MT002', 'ID001', '2022-12-15', '2022-12-16', 1, 0),
(2, 'MT003', 'ID002', '2022-12-15', '2022-12-23', 8, 0),
(3, 'MT004', 'ID003', '2022-12-14', '2022-12-21', 7, 0),
(4, 'MT006', 'ID006', '2022-12-16', '2022-12-29', 13, 0),
(5, 'MT009', 'ID008', '2022-12-19', '2022-12-21', 2, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `locations`
--
ALTER TABLE `locations`
  ADD PRIMARY KEY (`idl`),
  ADD KEY `locations_clients_FK` (`client`),
  ADD KEY `locations_voiture_FK` (`voiture`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `locations`
--
ALTER TABLE `locations`
  ADD CONSTRAINT `locations_clients_FK` FOREIGN KEY (`client`) REFERENCES `clients` (`matricule`),
  ADD CONSTRAINT `locations_voiture_FK` FOREIGN KEY (`voiture`) REFERENCES `voitures` (`idVoiture`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
