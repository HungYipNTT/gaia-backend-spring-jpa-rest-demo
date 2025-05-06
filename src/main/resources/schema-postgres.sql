-- File: ddl/new_sale_platform.sql

CREATE SCHEMA IF NOT EXISTS new_sale_platform;

CREATE TABLE IF NOT EXISTS new_sale_platform.customer (
    id SERIAL PRIMARY KEY,
    title VARCHAR(10),
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    email VARCHAR(100),
    contact_no VARCHAR(15),
    date_of_birth DATE,
    card_no VARCHAR(20),
    expiry_date DATE,
    card_holder_name VARCHAR(100),
    address_line_1 VARCHAR(255),
    address_line_2 VARCHAR(255),
    city VARCHAR(100),
    country VARCHAR(100),
    postcode VARCHAR(10),
    created_by VARCHAR(100) DEFAULT CURRENT_USER,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_upd_by VARCHAR(100) DEFAULT CURRENT_USER,
    last_upd_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    ver BIGINT DEFAULT 1
);

CREATE SEQUENCE IF NOT EXISTS new_sale_platform.product_seq;

CREATE TABLE IF NOT EXISTS new_sale_platform.product (
    id BIGINT PRIMARY KEY DEFAULT nextval('new_sale_platform."product_seq"'),
    code VARCHAR(50),
    category VARCHAR(50),
    brand VARCHAR(50),
    product_name VARCHAR(100),
    style VARCHAR(50),
    short_description TEXT,
    unit_price DECIMAL,
    created_by VARCHAR(100) DEFAULT CURRENT_USER,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_upd_by VARCHAR(100) DEFAULT CURRENT_USER,
    last_upd_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    ver BIGINT DEFAULT 1
);

CREATE TABLE IF NOT EXISTS new_sale_platform.hoodie (
    id BIGINT PRIMARY KEY REFERENCES new_sale_platform.product(id),
    size VARCHAR(5),
    color VARCHAR(50),
    composition TEXT,
    care_instructions TEXT
);

CREATE TABLE IF NOT EXISTS new_sale_platform.trainer (
    id BIGINT PRIMARY KEY REFERENCES new_sale_platform.product(id),
    size VARCHAR(5),
    color VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS new_sale_platform.backpack (
    id BIGINT PRIMARY KEY REFERENCES new_sale_platform.product(id),
    color VARCHAR(50),
    strap_type VARCHAR(50),
    material TEXT,
    fastenings TEXT,
    pockets INT,
    care_instructions TEXT,
    weatherproof BOOLEAN
);

CREATE TABLE IF NOT EXISTS new_sale_platform.order (
    order_number SERIAL PRIMARY KEY,
    customer_id BIGINT REFERENCES new_sale_platform.customer(id),
    promotion_code VARCHAR(50),
    discount DECIMAL,
    vat DECIMAL,
    total_amount DECIMAL,
    payment_reference VARCHAR(100),
    shipping_address TEXT,
    created_by VARCHAR(100) DEFAULT CURRENT_USER,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_upd_by VARCHAR(100) DEFAULT CURRENT_USER,
    last_upd_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    ver BIGINT DEFAULT 1
);

CREATE TABLE IF NOT EXISTS new_sale_platform.order_item (
    item_id SERIAL PRIMARY KEY,
    order_number BIGINT REFERENCES new_sale_platform.order(order_number),
    product_id BIGINT REFERENCES new_sale_platform.product(id),
    short_description TEXT,
    qty INT,
    unit_price DECIMAL,
    amount DECIMAL
);
