CREATE TABLE IF NOT EXISTS jobs
(
    `job_id`          BIGINT NOT NULL PRIMARY KEY,
    `start_date`      DATE,
    `end_date`        DATE,
    `completed`       BOOLEAN,
    `invoiced`        BOOLEAN,
    `invoice_number`  VARCHAR(20),
    `note`            VARCHAR(255)
);
