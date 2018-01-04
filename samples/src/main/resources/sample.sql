CREATE TABLE patient (patient_key int not null primary key AUTO_INCREMENT, patient_id varchar(10) not null, patient_name varchar(64) not null, patient_birthdate varchar(10), patient_gender integer);
CREATE TABLE encounter (encounter_key int not null primary key AUTO_INCREMENT, encounter_number varchar(64), encounter_pat_class varchar(64), encounter_admit_datetime varchar(20), encounter_discharge_datetime varchar(20), attend_doctor varchar(64), department varchar(64), patient_key int not null, foreign key (patient_key) references patient (patient_key);
CREATE TABLE order (key int not null primary key AUTO_INCREMENT, patientid varchar(64), patientname varchar(64), gender char(1), birthdate varchar(20), department varchar(64), room varchar(20), bed varchar(20), ordername varchar(255));

CREATE TABLE order (order_key int not null primary key AUTO_INCREMENT, patientid varchar(10) not null, patientname varchar(64) not null, birthdate varchar(10), gender integer);
