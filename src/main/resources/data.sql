INSERT INTO visitor (first_name, last_name) VALUES ('John', 'Birb');
INSERT INTO visitor (first_name, last_name) VALUES ('Meg', 'Ryan');
INSERT INTO visitor (first_name, last_name) VALUES ('Jason', 'Derullo');
INSERT INTO visitor (first_name, last_name) VALUES ('Chris', 'Paul');

INSERT INTO meal (name, description) VALUES ('Pizza pepperoni', 'pizza z pepperoni');
INSERT INTO meal (name, description) VALUES ('Spaghetti Bolognese', 'makaron z sosem');
INSERT INTO meal (name, description) VALUES ('Shake', 'napoj');
INSERT INTO meal (name, description) VALUES ('Pizza napoletana', 'pizza cienka');

INSERT INTO review (date, message, rate, meal_id, visitor_id) VALUES ('2020-10-03', 'Polecam', 5, 1, 1);
INSERT INTO review (date, message, rate, meal_id, visitor_id) VALUES ('2020-10-03', 'smaczne', 1, 1, 2);
INSERT INTO review (date, message, rate, meal_id, visitor_id) VALUES ('2020-10-03', 'fajne', 2, 2, 1);
INSERT INTO review (date, message, rate, meal_id, visitor_id) VALUES ('2020-10-03', 'Ok', 4, 2, 2);