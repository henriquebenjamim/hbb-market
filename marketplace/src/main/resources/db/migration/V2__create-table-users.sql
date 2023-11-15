CREATE TABLE users (
    id UUID PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(55) NOT NULL,
    CONSTRAINT unique_email UNIQUE (email)
);
