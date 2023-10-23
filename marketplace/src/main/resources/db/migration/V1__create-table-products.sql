CREATE TABLE products (
    id      UUID    PRIMARY KEY NOT NULL,
    name    TEXT                NOT NULL,
    price   FLOAT               NOT NULL,
    image   TEXT,
    active  BOOLEAN             NOT NULL
);