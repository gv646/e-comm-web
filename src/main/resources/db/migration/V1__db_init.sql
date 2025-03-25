CREATE TABLE category
(
    id   BINARY(16)   NOT NULL,
    name VARCHAR(255) NOT NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE j_mentors
(
    user_id BIGINT NOT NULL,
    avg_rating DOUBLE NOT NULL,
    CONSTRAINT pk_j_mentors PRIMARY KEY (user_id)
);

CREATE TABLE j_students
(
    user_id BIGINT NOT NULL,
    psp DOUBLE NOT NULL,
    CONSTRAINT pk_j_students PRIMARY KEY (user_id)
);

CREATE TABLE j_ta
(
    user_id    BIGINT NOT NULL,
    ta_session VARCHAR(255) NULL,
    CONSTRAINT pk_j_ta PRIMARY KEY (user_id)
);

CREATE TABLE j_user
(
    id    BIGINT AUTO_INCREMENT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    CONSTRAINT pk_j_user PRIMARY KEY (id)
);

CREATE TABLE ms_mentors
(
    id    BIGINT AUTO_INCREMENT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    avg_rating DOUBLE NOT NULL,
    CONSTRAINT pk_ms_mentors PRIMARY KEY (id)
);

CREATE TABLE ms_students
(
    id    BIGINT AUTO_INCREMENT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    psp DOUBLE NOT NULL,
    CONSTRAINT pk_ms_students PRIMARY KEY (id)
);

CREATE TABLE ms_ta
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    name       VARCHAR(255) NULL,
    email      VARCHAR(255) NULL,
    ta_session VARCHAR(255) NULL,
    CONSTRAINT pk_ms_ta PRIMARY KEY (id)
);

CREATE TABLE orders
(
    id BINARY(16) NOT NULL,
    CONSTRAINT pk_orders PRIMARY KEY (id)
);

CREATE TABLE price
(
    id       BINARY(16)   NOT NULL,
    currency VARCHAR(255) NULL,
    value DOUBLE NOT NULL,
    CONSTRAINT pk_price PRIMARY KEY (id)
);

CREATE TABLE product
(
    id            BINARY(16)   NOT NULL,
    title         VARCHAR(255) NULL,
    `description` VARCHAR(255) NULL,
    image         VARCHAR(255) NULL,
    category_id   BINARY(16)   NOT NULL,
    price_id      BINARY(16)   NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE products_orders
(
    order_id   BINARY(16) NOT NULL,
    product_id BINARY(16) NOT NULL
);

CREATE TABLE st_user
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    user_type  INT NULL,
    name       VARCHAR(255) NULL,
    email      VARCHAR(255) NULL,
    ta_session VARCHAR(255) NULL,
    avg_rating DOUBLE NOT NULL,
    psp DOUBLE NOT NULL,
    CONSTRAINT pk_st_user PRIMARY KEY (id)
);

CREATE TABLE tpc_mentors
(
    id    BIGINT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    avg_rating DOUBLE NOT NULL,
    CONSTRAINT pk_tpc_mentors PRIMARY KEY (id)
);

CREATE TABLE tpc_students
(
    id    BIGINT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    psp DOUBLE NOT NULL,
    CONSTRAINT pk_tpc_students PRIMARY KEY (id)
);

CREATE TABLE tpc_ta
(
    id         BIGINT NOT NULL,
    name       VARCHAR(255) NULL,
    email      VARCHAR(255) NULL,
    ta_session VARCHAR(255) NULL,
    CONSTRAINT pk_tpc_ta PRIMARY KEY (id)
);

CREATE TABLE tpc_user
(
    id    BIGINT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    CONSTRAINT pk_tpc_user PRIMARY KEY (id)
);

ALTER TABLE j_mentors
    ADD CONSTRAINT FK_J_MENTORS_ON_USER FOREIGN KEY (user_id) REFERENCES j_user (id);

ALTER TABLE j_students
    ADD CONSTRAINT FK_J_STUDENTS_ON_USER FOREIGN KEY (user_id) REFERENCES j_user (id);

ALTER TABLE j_ta
    ADD CONSTRAINT FK_J_TA_ON_USER FOREIGN KEY (user_id) REFERENCES j_user (id);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_PRICE FOREIGN KEY (price_id) REFERENCES price (id);

ALTER TABLE products_orders
    ADD CONSTRAINT fk_proord_on_order FOREIGN KEY (order_id) REFERENCES orders (id);

ALTER TABLE products_orders
    ADD CONSTRAINT fk_proord_on_product FOREIGN KEY (product_id) REFERENCES product (id);