ALTER TABLE machines
    ADD `customer_id` BIGINT;
ALTER TABLE machines
    ADD CONSTRAINT customer_id
        FOREIGN KEY (`customer_id`) REFERENCES customers (id);