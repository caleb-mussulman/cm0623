DELETE FROM tool;
DELETE FROM tool_type;

INSERT INTO tool_type
(id, tool_name, charge_amount, is_weekday_charge, is_weekend_charge, is_holiday_charge)
VALUES
(1, 'Ladder',     1.99, true, true,  false),
(2, 'Chainsaw',   1.49, true, false, true),
(3, 'Jackhammer', 2.99, true, false, false);

INSERT INTO tool
(code, tool_type_id, brand)
VALUES
('CHNS', 2, 'Stihl'),
('LADW', 1, 'Werner'),
('JAKD', 3, 'DeWalt'),
('JAKR', 3, 'Ridgid');