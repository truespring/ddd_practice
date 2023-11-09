truncate table member;
truncate table payment;
truncate table wallet;

insert into member (member_id, blocked, name, emails, password, activated) values (1, false, 'John', '123@ad.com', '123', true);
insert into member (member_id, blocked, name, emails, password, activated) values (2, false, 'Mary', 'mary@ad.com', '142', true);
insert into member (member_id, blocked, name, emails, password, activated) values (3, false, 'Kate', 'kkkee@ad.com', '325', true);

insert into payment (payment_number, amount, date, method, member_id, state) values (1, 10000, now(), 'CARD', 1, 'COMPLETED');
insert into payment (payment_number, amount, date, method, member_id, state) values (2, 100000, now(), 'CARD', 2, 'COMPLETED');
insert into payment (payment_number, amount, date, method, member_id, state) values (3, 10000, now(), 'CARD', 1, 'CANCELED');

insert into wallet (wallet_number, total_amounts, member_id) values (1, 10000, 1);
insert into wallet (wallet_number, total_amounts, member_id) values (2, 10000, 2);