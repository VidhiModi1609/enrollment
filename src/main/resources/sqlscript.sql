
 
CREATE TABLE Enrollee (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250),
  activation_status char(1), 
  birth_date DATE,
  phone_number VARCHAR(250)
);

CREATE TABLE Dependent (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250),
  birth_date DATE,
  enrollee_id INT NOT NULL,
  CONSTRAINT enrollee_id FOREIGN KEY (enrollee_id) REFERENCES Enrollee (id)
);
 
INSERT INTO Enrollee (name, activation_status,birth_date,phone_number) VALUES
  ('Radha','Y','2020-1-17', '9908059899');
  
  INSERT INTO Dependent (name,birth_date,enrollee_id) VALUES
  ('Sasa','2020-1-17', 1);