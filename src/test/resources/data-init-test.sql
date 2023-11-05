truncate table member;
truncate table payment;
truncate table wallet;

insert into member (member_id, blocked, name, emails, password, activated) values (1, false, 'John', '123@ad.com', '123', true);
insert into member (member_id, blocked, name, emails, password, activated) values (2, false, 'Mary', 'mary@ad.com', '142', true);
insert into member (member_id, blocked, name, emails, password, activated) values (3, false, 'Kate', 'kkkee@ad.com', '325', true);

insert into payment (payment_number, amount, date, method, orderer_id, state) values (1, 10000, now(), 'CARD', 1, 'COMPLETED');

insert into wallet (wallet_number, total_amounts, member_id) values (1, 10000, 1);