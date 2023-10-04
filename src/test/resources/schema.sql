CREATE TABLE IF NOT EXISTS jobs
(
    `job_id`         BIGINT NOT NULL PRIMARY KEY,
    `start_date`     DATE,
    `end_date`       DATE,
    `completed`      BOOLEAN,
    `invoiced`       BOOLEAN,
    `invoice_number` VARCHAR(20),
    `note`           VARCHAR(255),
    `serial_number`  VARCHAR(20),
    `status`  VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS machines
(
    `serial_number`        varchar(20) NOT NULL PRIMARY KEY,
    `type`                 VARCHAR(10),
    `control_type`         VARCHAR(20),
    `machine_hours`        INT,
    `spindle_hours`        INT,
    `nc_software_version`  VARCHAR(15),
    `plc_software_version` VARCHAR(15),
    `created_at`           DATETIME,
    `last_updated_at`      DATETIME,
    `customer_id`          BIGINT
);

ALTER TABLE jobs
    ADD CONSTRAINT serial_number FOREIGN KEY (serial_number) REFERENCES machines(serial_number) ;