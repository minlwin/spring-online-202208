-- Truncate tables
set foreign_key_checks = 0;

truncate table member;
truncate table ledger;
truncate table entry_data;

set foreign_key_checks = 1;


-- Insert Members Data
insert into member(name, email, role, create_date, password) values 
('Admin User', 'admin@gmail.com', 'Admin', '2022-11-01', '$2a$10$Ebhsew9hcCJriRShsVkALOzppuGlWPhKxvZhx4vQaL5K7QgURsxvy'),
('Member', 'member@gmail.com', 'Member', '2022-11-15', '$2a$10$vjFhgmQ7UNBjlE6uW8LkdOJ3CkeHi7NrxKFnWEH9mlz.p/frHnp12');
