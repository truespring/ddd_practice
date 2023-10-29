truncate table member;
truncate table payment;
truncate table wallet;

insert into member (member_id, blocked, name, emails, password) values (1, false, 'John', '123@ad.com', '123');
insert into member (member_id, blocked, name, emails, password) values (2, false, 'Mary', 'mary@ad.com', '142');
insert into member (member_id, blocked, name, emails, password) values (3, false, 'Kate', 'kkkee@ad.com', '325');

insert into payment (payment_number, amounts, date, method, orderer_id, state) values (1, 10000, now(), 'CARD', 1, 'COMPLETED');

insert into wallet (wallet_number, total_amounts, orderer_id) values (1, 10000, 1);