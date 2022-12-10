-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 10, 2022 at 03:23 PM
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
-- Table structure for table `clients`
--

CREATE TABLE `clients` (
  `matricule` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `nom` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `permis` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `adresse` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  `telephone` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `clients`
--

INSERT INTO `clients` (`matricule`, `nom`, `permis`, `adresse`, `telephone`) VALUES
('MT002', 'John Abotte', 'PM002', '1202 Sherbrooke West apt. 12', '514 222 3333'),
('MT003', 'William Smith', 'PM003', '3601 St-Jacuqes', '514 111 2222'),
('MT004', 'John Abotte', 'PM004', '1202 Sherbrooke West apt. 12', '514 222 3333'),
('MT005', 'William Smith', 'PM005', '3601 St-Jacuqes', '514 111 2222'),
('MT006', 'John Abo', 'PM006', '1202 Sherbrooke West apt. 12', '514 222 3333'),
('MT007', 'William Smith', 'PM007', '3601 St-Jacuqes', '514 111 2222'),
('MT008', 'John Abotte', 'PM008', '1202 Sherbrooke West apt. 12', '514 222 3333'),
('MT009', 'William Smith', 'PM009', '3601 St-Jacuqes', '514 111 2222'),
('MT010', 'John Abotte', 'PM010', '1202 Sherbrooke West apt. 12', '514 222 3333'),
('MT011', 'William Smith', 'PM011', '3601 St-Jacuqes', '514 111 2222'),
('MT012', 'John Abotte', 'PM012', '1202 Sherbrooke West apt. 12', '514 222 3333'),
('MT013', 'William Smith', 'PM013', '3601 St-Jacuqes', '514 111 2222'),
('MT014', 'Philip Dawson', 'PM014', '2014 avenu Atwater', '514 555 6666'),
('MT015', 'John Abotte', 'PM010', '1202 Sherbrooke West apt. 12', '514 222 3333');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`matricule`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
