create schema kaml;
CREATE SEQUENCE quote_id_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE kaml.user_id_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE kaml.vote_id_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE "user"
(
    id       BIGINT NOT NULL,
    name     VARCHAR(255),
    email    VARCHAR(255),
    password VARCHAR(255),
    creation TIMESTAMP,
    CONSTRAINT pk_user PRIMARY KEY (id)
);

CREATE TABLE QUOTE
(
    id         BIGINT NOT NULL,
    content    VARCHAR(255),
    createDate TIMESTAMP,
    updateDate TIMESTAMP,
    userId     BIGINT REFERENCES "user",
    votes     BIGINT,
    CONSTRAINT pk_quoteentity PRIMARY KEY (id)
);

CREATE TABLE vote
(
    id          BIGINT NOT NULL,
    user_id     BIGINT REFERENCES "user",
    quote_id    BIGINT REFERENCES QUOTE,
    create_date TIMESTAMP,
    update_date TIMESTAMP,
    CONSTRAINT pk_vote PRIMARY KEY (id)
);