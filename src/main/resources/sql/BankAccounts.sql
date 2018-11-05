-- create table

CREATE TABLE bank_accounts(
  id        BIGSERIAL             NOT NULL ,
  account   VARCHAR (10)          NOT NULL ,
  deposit   NUMERIC (15,6)        NOT NULL ,
  credit    NUMERIC(15, 6)        NOT NULL ,
  state     BOOLEAN               NOT NULL ,
  bank_accounts_customers BIGINT,
  CONSTRAINT bank_accounts_customers_fkey FOREIGN KEY (bank_accounts_customers) REFERENCES customers(id) ON DELETE CASCADE ,
  PRIMARY KEY (id),
  UNIQUE (account)
)

-- delete the table

DROP TABLE bank_accounts cascade ;

