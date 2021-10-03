CREATE SCHEMA IF NOT EXISTS job_manager;
CREATE TABLE IF NOT EXISTS customers
(
    `id`                  BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `company_name`        VARCHAR(50),
    `contact_person_name` VARCHAR(30),
    `primary_email`       VARCHAR(30),
    `secondary_email`     VARCHAR(30),
    `address`             VARCHAR(150),
    `vat_number`          VARCHAR(20),
    `account_number`      VARCHAR(50)
);
