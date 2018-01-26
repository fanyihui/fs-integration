CREATE TABLE med_order (
  PatientName varchar(64),
  PatientID varchar(64),
  PatientGender char(1),
  PatientBirth varchar(11),
  Department varchar(64),
  Room varchar(20),
  Bed varchar(20),
  Weight float,
  Height float,
  OrderName varchar(255),
  PatientType int,
  IsActive int
);