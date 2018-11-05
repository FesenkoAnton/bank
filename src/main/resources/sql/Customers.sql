-- create table customers

CREATE TABLE customers(
  id                    BIGSERIAL             NOT NULL ,
  name                  VARCHAR (10)          NOT NULL ,
  surname               VARCHAR (25)          NOT NULL ,
  phone                 VARCHAR(12)           NOT NULL ,
  PRIMARY KEY (id),
  UNIQUE (phone)
)

--delete the table

DROP TABLE customers cascade ;