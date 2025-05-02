INSERT INTO new_sale_platform.customer
    (title, first_name, last_name, email, contact_no, date_of_birth, 
    card_no, expiry_date, card_holder_name, address_line_1, address_line_2, city, country, postcode)
VALUES 
    ('Mr.', 'John', 'Doe', 'john.doe@example.com', '123456789', '1990-01-01', 
    '4111111111111111', '2025-12-01', 'John Doe', '123 Elm St', '', 'Metropolis', 'USA', '12345'),
    ('Mrs.', 'Jane', 'Smith', 'jane.smith@example.com', '987654321', '1985-02-14', 
    '4222222222222222', '2026-01-15', 'Jane Smith', '456 Oak Rd', 'Apt 101', 'Gotham', 'USA', '54321'),
    ('Ms.', 'Emily', 'Johnson', 'emily.johnson@example.com', '456789123', '1992-05-31', 
    '4333333333333333', '2023-05-31', 'Emily Johnson', '789 Pine Ave', '', 'Central City', 'USA', '11223'),
    ('Dr.', 'Michael', 'Brown', 'michael.brown@example.com', '111222333', '1976-08-19', 
    '4444444444444444', '2027-07-11', 'Michael Brown', '101 Maple St', 'Suite B', 'Star City', 'USA', '33445'),
    ('Ms.', 'Sarah', 'Williams', 'sarah.williams@example.com', '222333444', '1982-03-06', 
    '4555555555555555', '2024-06-22', 'Sarah Williams', '202 Cedar Dr', '', 'Smallville', 'USA', '55678'),
    ('Mr.', 'David', 'Jones', 'david.jones@example.com', '333444555', '1995-11-17', 
    '4666666666666666', '2029-11-17', 'David Jones', '303 Birch Ln', '', 'Atlantis', 'USA', '87901'),
    ('Mrs.', 'Linda', 'Martinez', 'linda.martinez@example.com', '444555666', '1988-07-29', 
    '4777777777777777', '2030-03-05', 'Linda Martinez', '404 Spruce Ct', 'Unit 12', 'Krypton', 'USA', '10196'),
    ('Mr.', 'Robert', 'Hernandez', 'robert.hernandez@example.com', '555666777', '1993-10-02', 
    '4888888888888888', '2028-09-15', 'Robert Hernandez', '505 Walnut Dr', '', 'Ivytown', 'USA', '67482'),
    ('Ms.', 'Maria', 'Clark', 'maria.clark@example.com', '666777888', '1976-01-21', 
    '4999999999999999', '2026-08-28', 'Maria Clark', '606 Cherry St', '', 'Fawcett City', 'USA', '32456'),
    ('Dr.', 'James', 'Lewis', 'james.lewis@example.com', '777888999', '1970-04-08', 
    '4033333322221111', '2025-01-01', 'James Lewis', '707 Willow Ave', 'Floor 3', 'Hub City', 'USA', '54378');

INSERT INTO new_sale_platform.hoodie 
    (code, category, brand, product_name, style, short_description, unit_price)
VALUES 
    ('P001', 'hoodie', 'Nike', 'Air Hoodie', 'Casual', 'Comfortable hoodies', 59.99),
    ('P004', 'hoodie', 'Puma', 'Sport Hoodie', 'Fitness', 'Stretchable hoodies', 49.99),
    ('P007', 'hoodie', 'Gap', 'GAP Hoodie', 'Casual', 'Everyday hoodies', 29.99),
    ('P010', 'hoodie', 'Under Armour', 'Game Hoodie', 'Competitive', 'Warm hoodies', 39.99);

INSERT INTO new_sale_platform.trainer 
    (code, category, brand, product_name, style, short_description, unit_price)
VALUES 
    ('P002', 'trainer', 'Adidas', 'Run Trainer', 'Sporty', 'Lightweight trainers', 89.99),
    ('P005', 'trainer', 'Reebok', 'Classic Trainer', 'Classic', 'Old school trainers', 79.99),
    ('P008', 'trainer', 'New Balance', 'Balance Trainer', 'Running', 'Perfect balance', 69.99);

INSERT INTO new_sale_platform.backpack 
    (code, category, brand, product_name, style, short_description, unit_price)
VALUES 
    ('P003', 'backpack', 'North Face', 'Mountain Backpack', 'Outdoor', 'Durable backpacks', 129.99),
    ('P006', 'backpack', 'Nike', 'Nike Backpack', 'Sport', 'Stylish backpacks', 99.99),
    ('P009', 'backpack', 'Adidas', 'Travel Backpack', 'Travel', 'Completed backpacks', 119.99);