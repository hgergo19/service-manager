ALTER TABLE jobs
    ADD `serial_number` VARCHAR(20);
ALTER TABLE jobs
    ADD CONSTRAINT serial_number
        FOREIGN KEY (`serial_number`) REFERENCES machines (serial_number) ;