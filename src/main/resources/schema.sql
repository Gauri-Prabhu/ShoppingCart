DROP TABLE IF EXISTS PRODUCT;
CREATE TABLE PRODUCT (
id INT AUTO_INCREMENT  PRIMARY KEY,
item_name VARCHAR(50) NOT NULL,
price INT(8) NOT NULL,
offer BOOLEAN,
offer_detail VARCHAR(50),
buy_quantity INT(8),
buy_at_cost_of_quantity INT(8)
);