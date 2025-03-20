CREATE TABLE IF NOT EXISTS load (
    load_id UUID PRIMARY KEY,
    loading_point VARCHAR(255),
    unloading_point VARCHAR(255),
    loading_date TIMESTAMP,
    unloading_date TIMESTAMP,
    product_type VARCHAR(255),
    truck_type VARCHAR(255),
    no_of_trucks INT,
    weight DOUBLE PRECISION,
    comment TEXT,
    shipper_id UUID,
    date TIMESTAMP
);