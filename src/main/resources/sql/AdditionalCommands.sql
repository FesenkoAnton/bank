INSERT INTO customers(name,surname,phone) VALUES ('AN','DH','380508795451');
INSERT INTO bank_accounts (account, deposit, credit, state, bank_accounts_customers) VALUES ('1234567890',100.0,100.0,true,(select id from customers where name='AN'));
INSERT INTO cards (number, cards_bank_accounts) VALUES ('1254 5485 1245 4578',(select id from bank_accounts where account='1234567890'));

INSERT INTO customers(name,surname,phone) VALUES ('SD','MD','380508795452');
INSERT INTO bank_accounts (account, deposit, credit, state, bank_accounts_customers) VALUES ('1234567891',100.0,100.0,true,(select id from customers where name='SD'));
INSERT INTO cards (number, cards_bank_accounts) VALUES ('1254 5485 1245 4572',(select id from bank_accounts where account='1234567891'));

INSERT INTO customers(name,surname,phone) VALUES ('AL','DL','380508795453');
INSERT INTO bank_accounts (account, deposit, credit, state, bank_accounts_customers) VALUES ('1234567892',100.0,100.0,true,(select id from customers where name='AL'));
INSERT INTO cards (number, cards_bank_accounts) VALUES ('1254 5485 1245 4573',(select id from bank_accounts where account='1234567892'));



delete from customers where name='AN';
delete from bank_accounts where account='1234567890';
delete from cards where number='1254 5485 1245 4578';
