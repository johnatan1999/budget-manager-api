/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  John
 * Created: 26 mars 2023
 */

DROP TABLE IF EXISTS Budget;
DROP TABLE IF EXISTS Categorie;
DROP TABLE IF EXISTS Label;
DROP TABLE IF EXISTS Transaction_;
 
CREATE TABLE Budget (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  description VARCHAR(250) NOT NULL,
  start_date DATE NOT NULL,
  end_date DATE NOT NULL,
  amount DOUBLE,
  state_ INT NOT NULL
);

CREATE TABLE Category (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  category_name VARCHAR(50),
  transaction_type VARCHAR(20)
);

CREATE TABLE Label (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  description VARCHAR(250) NOT NULL
);

CREATE TABLE Transaction_ (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  amount double NOT NULL,
  description VARCHAR(250) NOT NULL,
  transaction_date Date NOT NULL DEFAULT (CURRENT_DATE),
  transaction_time Time NOT NULL DEFAULT (CURRENT_TIME),
  state_ INT NOT NULL,
  category_id int references category(id) 
);
 
INSERT INTO Label (description) VALUES
  ('Perso'),
  ('Commun');

INSERT INTO Category (category_name, transaction_type) VALUES
  ('Kaly', 'expense'),
  ('Collation', 'expense'),
  ('Santé', 'expense'),
  ('Salaire', 'income'),
  ('Loterie, jeux de hazard', 'expense'),
  ('Transport', 'expense'),
  ('Papeterie', 'expense'),
  ('Vêtement & Chaussures', 'expense'),
  ('Maison', 'expense'),
  ('Electroniques, accessoires', 'expense'),
  ('Education', 'expense'),
  ('Sport', 'expense'),
  ('Cadeaux', 'expense'),
  ('Allocations familiales', 'income'),
  ('Autre', 'income/expense'),
  ('Sera', 'income');


INSERT INTO Transaction_ (description, transaction_date, amount, state_, category_id) VALUES ('Salaire Janvier', '2023-04-02', 900000, 1, 4);
INSERT INTO Transaction_ (description, transaction_date, amount, state_, category_id) VALUES ('Description', '2023-04-02', 80000, 1, 5);
INSERT INTO Transaction_ (description, transaction_date, amount, state_, category_id) VALUES ('Achat n°1', '2023-04-02', -9000, 0, 1);
INSERT INTO Transaction_ (description, transaction_date, amount, state_, category_id) VALUES ('Salaire Mars', '2023-04-02', 90000, 0, 4);
INSERT INTO Transaction_ (description, transaction_date, amount, state_, category_id) VALUES ('Salaire Avril', '2023-04-02', 90000, 0, 4);
INSERT INTO Transaction_ (description, transaction_date, amount, state_, category_id) VALUES ('Achat n°2', '2023-04-03', -5000, 0, 2);
INSERT INTO Transaction_ (description, transaction_date, amount, state_, category_id) VALUES ('Salaire Mai', '2023-04-03', 90000, 0, 4);
INSERT INTO Transaction_ (description, transaction_date, amount, state_, category_id) VALUES ('Salaire Juin', '2023-04-03', 90000, 0, 4);
INSERT INTO Transaction_ (description, transaction_date, amount, state_, category_id) VALUES ('Salaire Juillet', '2023-04-03', 90000, 0, 4);
INSERT INTO Transaction_ (description, transaction_date, amount, state_, category_id) VALUES ('Achat n°3', '2023-04-03', -600000, 0, 3);
INSERT INTO Transaction_ (description, transaction_date, amount, state_, category_id) VALUES ('Salaire Aout', '2023-04-03', 90000, 0, 4);
INSERT INTO Transaction_ (description, transaction_date, amount, state_, category_id) VALUES ('Achat n°4', '2023-04-03', -1000, 0, 1);
INSERT INTO Transaction_ (description, transaction_date, amount, state_, category_id) VALUES ('Achat n°5', '2023-04-03', -2000, 0, 2);
INSERT INTO Transaction_ (description, transaction_date, amount, state_, category_id) VALUES ('Salaire Septembre', '2023-04-03', 90000, 0, 4);
INSERT INTO Transaction_ (description, transaction_date, amount, state_, category_id) VALUES ('Salaire Octobre', '2023-04-04', 90000, 0, 4);
INSERT INTO Transaction_ (description, transaction_date, amount, state_, category_id) VALUES ('Salaire Novembre', '2023-04-04', 90000, 0, 4);
INSERT INTO Transaction_ (description, transaction_date, amount, state_, category_id) VALUES ('Salaire Decembre', '2023-04-04', 90000, 0, 4);
INSERT INTO Transaction_ (description, transaction_date, amount, state_, category_id) VALUES ('Sera', '2023-04-04', 90000, 0, 5);
INSERT INTO Transaction_ (description, transaction_date, amount, state_, category_id) VALUES ('Mdegat', '2023-04-04', -100000, 0, 1);
INSERT INTO Transaction_ (description, transaction_date, amount, state_, category_id) VALUES ('Essaie', '2023-04-04', -20000, 0, 3);


commit;