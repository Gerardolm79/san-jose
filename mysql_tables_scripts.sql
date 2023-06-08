-- san_jose.clients definition

CREATE TABLE `clients` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `mobile` varchar(20) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `phone` varchar(20) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `email` varchar(50) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `create_at` date DEFAULT NULL,
  `notes` varchar(200) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- san_jose.products definition

CREATE TABLE `products` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Code` varchar(20) DEFAULT NULL,
  `Name` varchar(50) DEFAULT NULL,
  `Brand` varchar(20) DEFAULT NULL,
  `Description` varchar(200) DEFAULT NULL,
  `Category` varchar(20) DEFAULT NULL,
  `Price` decimal(10,0) DEFAULT NULL,
  `Existences` smallint DEFAULT NULL,
  `Unit` varchar(10) DEFAULT NULL,
  `Min` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- san_jose.providers definition

CREATE TABLE `providers` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) DEFAULT NULL,
  `Phone` varchar(20) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  `Description` varchar(200) DEFAULT NULL,
  `modified_date` date DEFAULT NULL,
  `registered_date` date DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
