#!/bin/bash


# RUN with `bash db_setup.sh root <password>`


# Parse command-line arguments
if [ "$#" -ne 2 ]; then
    echo "Usage: $0 <root_username> <root_password>"
    exit 1
fi

MYSQL_ROOT_USER="$1"
MYSQL_ROOT_PASSWORD="$2"

NEW_USERNAME="admin"
NEW_PASSWORD="password"

DATABASE_NAME="inventory"

MYSQL_COMMANDS=$(cat <<EOF
CREATE DATABASE IF NOT EXISTS $DATABASE_NAME;
CREATE USER IF NOT EXISTS '$NEW_USERNAME'@'localhost' IDENTIFIED BY '$NEW_PASSWORD';
GRANT ALL PRIVILEGES ON $DATABASE_NAME.* TO '$NEW_USERNAME'@'localhost';
FLUSH PRIVILEGES;
EOF
)

echo "$MYSQL_COMMANDS" | mysql -u $MYSQL_ROOT_USER -p$MYSQL_ROOT_PASSWORD

echo "New MySQL user '$NEW_USERNAME' created with password '$NEW_PASSWORD' and granted all privileges on database '$YOUR_DATABASE_NAME'."

#-- Drop tables if they exist
#DROP TABLE IF EXISTS products;
#DROP TABLE IF EXISTS product_unit_of_measure;
#DROP TABLE IF EXISTS product_category;
#
#-- Create product_category table
#CREATE TABLE IF NOT EXISTS product_category (
#    id INT PRIMARY KEY,
#    name VARCHAR(255),
#    description VARCHAR(255)
#);
#
#-- Insert data into product_category
#INSERT INTO product_category (id, name, description) VALUES
#(1, 'Furniture', 'Products for furniture');
#
#-- Create product_unit_of_measure table
#CREATE TABLE IF NOT EXISTS product_unit_of_measure (
#    id INT PRIMARY KEY,
#    unit VARCHAR(20),
#    description VARCHAR(255)
#);
#
#-- Insert data into product_unit_of_measure
#INSERT INTO product_unit_of_measure (id, unit, description) VALUES
#(0, 'pcs', 'Pieces of a product');
#
#-- Create products table
#CREATE TABLE IF NOT EXISTS products (
#    id INT PRIMARY KEY,
#    name VARCHAR(255) NOT NULL,
#    description VARCHAR(255),
#    imagePaths VARCHAR(255),
#    canBeSold BOOLEAN,
#    canBePurchased BOOLEAN,
#    salesPrice FLOAT,
#    cost FLOAT,
#    quantity INT,
#    barcode VARCHAR(13),
#    unitOfMeasureId INT,
#    categoryId INT,
#    FOREIGN KEY (unitOfMeasureId) REFERENCES product_unit_of_measure(id),
#    FOREIGN KEY (categoryId) REFERENCES product_category(id)
#);