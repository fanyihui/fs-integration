CREATE TABLE patient (patient_key int not null primary key AUTO_INCREMENT, patient_id varchar(10) not null, patient_name varchar(64) not null, patient_birthdate varchar(10), patient_gender integer);
insert into patient ();
CREATE TABLE encounter (encounter_key int not null primary key AUTO_INCREMENT, encounter_number varchar(64), encounter_pat_class varchar(64), encounter_admit_datetime varchar(20), encounter_discharge_datetime varchar(20), attend_doctor varchar(64), department varchar(64), patient_key int not null, foreign key (patient_key) references patient (patient_key);
