-- create the table

CREATE TABLE cards(
  id        BIGSERIAL             NOT NULL ,
  number    VARCHAR (19)          NOT NULL ,
  cards_bank_accounts BIGINT,
  CONSTRAINT cards_bank_accounts_fkey FOREIGN KEY (cards_bank_accounts) REFERENCES bank_accounts(id) ON DELETE CASCADE ,
  PRIMARY KEY (id),
  UNIQUE (number)
)

--delete the table

DROP TABLE cards cascade;

