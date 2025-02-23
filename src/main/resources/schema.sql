DROP TABLE IF EXISTS price;
DROP TABLE IF EXISTS brand;
DROP TABLE IF EXISTS product;

CREATE TABLE IF NOT EXISTS brand (
  ID INT AUTO_INCREMENT PRIMARY KEY,
  NAME VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS product (
  ID INT AUTO_INCREMENT PRIMARY KEY,
  NAME VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS price (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    BRAND_ID BIGINT,
    START_DATE TIMESTAMP,
    END_DATE TIMESTAMP,
    PRICE_LIST INT,
    PRODUCT_ID BIGINT,
    PRIORITY INT,
    PRICE DECIMAL(10, 2),
    CURRENCY VARCHAR(3),
    CONSTRAINT fk_price_brand FOREIGN KEY (brand_id) REFERENCES brand (id),
    CONSTRAINT fk_price_product FOREIGN KEY (product_id) REFERENCES product (id)
);