CREATE TABLE IF NOT EXISTS machines
(
    `serial_number`                  varchar(20) NOT NULL PRIMARY KEY,
    `type`        VARCHAR(10),
    `control_type` VARCHAR(20),
    `machine_hours`     INT ,
    `spindle_hours`             INT ,
    `nc_software_version`          VARCHAR(15),
    `plc_software_version`      VARCHAR(15),
    `created_at`      DATETIME,
    `last_updated_at` DATETIME
    );
