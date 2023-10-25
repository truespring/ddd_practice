truncate table member;
truncate table payment;
truncate table wallet;

insert into member (member_id, blocked, name) values (1, false, 'John');
insert into member (member_id, blocked, name) values (2, false, 'Mary');
insert into member (member_id, blocked, name) values (3, false, 'Kate');

insert into payment (payment_number, amounts, date, method, orderer_id, state) values (1, 10000, now(), 'CARD', 1, 'COMPLETED');

insert into wallet (wallet_number, total_amounts, orderer_id) values (1, 10000, 1);