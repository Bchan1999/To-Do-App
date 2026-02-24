CREATE TABLE to_do (
    id BIGSERIAL PRIMARY KEY,
    date_created varchar(100) NOT NULL,
    date_due varchar(100),
    description varchar(100),
    header TEXT NOT NULL
);