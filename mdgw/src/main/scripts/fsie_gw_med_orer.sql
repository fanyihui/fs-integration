DROP TABLE IF EXISTS `med_order`;
CREATE TABLE `med_order` (
  `PatientName` varchar(64) DEFAULT NULL,
  `PatientID` varchar(64) DEFAULT NULL,
  `PatientGender` char(1) DEFAULT NULL,
  `PatientBirth` varchar(11) DEFAULT NULL,
  `Department` varchar(64) DEFAULT NULL,
  `Room` varchar(20) DEFAULT NULL,
  `Bed` varchar(20) DEFAULT NULL,
  `Weight` float DEFAULT NULL,
  `Height` float DEFAULT NULL,
  `OrderName` varchar(255) DEFAULT NULL,
  `PatientType` int(1) DEFAULT NULL,
  `IsActive` tinyint(1) NOT NULL DEFAULT '1',
  UNIQUE KEY `UN_PAT_BED` (`Bed`,`IsActive`)
)