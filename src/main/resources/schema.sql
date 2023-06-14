CREATE SCHEMA IF NOT EXISTS depot;
SET SCHEMA depot;

CREATE TABLE IF NOT EXISTS tool_type(
    id BIGINT PRIMARY KEY,
    tool_name VARCHAR NOT NULL,
    charge_amount DECIMAL(15,2) NOT NULL,
    is_weekday_charge BOOLEAN NOT NULL,
    is_weekend_charge BOOLEAN NOT NULL,
    is_holiday_charge BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS tool(
    code VARCHAR PRIMARY KEY,
    tool_type_id BIGINT,
    brand VARCHAR
);

ALTER TABLE tool
ADD FOREIGN KEY (tool_type_id)
REFERENCES tool_type(id);