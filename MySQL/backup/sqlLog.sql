-- set sql_safe_updates=0;

-- ALTER TABLE member RENAME COLUMN id to memberName;
-- ALTER TABLE member ADD memberId bigint;
-- ALTER TABLE member RENAME COLUMN name to nickname; 
-- ALTER TABLE member DROP PRIMARY KEY; 

-- ALTER TABLE member MODIFY memberId bigint not null auto_increment primary key;

 -- ALTER TABLE member add primary key(memberId);
 -- ALTER TABLE member RENAME COLUMN memberName to member_name;
 -- ALTER TABLE member RENAME COLUMN PASSWORD to password;
 -- ALTER TABLE member RENAME COLUMN memberId to member_id;
 
 -- ALTER TABLE emailtoken RENAME COLUMN id to email_token_id;
--  ALTER TABLE emailtoken RENAME COLUMN expirationDate to expiration_date;
--  ALTER TABLE emailtoken RENAME COLUMN memberId to member_id;

-- ALTER TABLE board RENAME COLUMN readCount to read_count;
-- ALTER TABLE board RENAME COLUMN seq to board_id;
-- ALTER TABLE board ADD member_id bigint;
-- ALTER TABLE board ADD CONSTRAINT fk_member_id FOREIGN KEY (member_id) references member(member_id);
-- ALTER TABLE emailtoken MODIFY member_id bigint;

-- ALTER TABLE emailtoken ADD member_name varchar(50);
-- set sql_safe_updates=0;
-- UPDATE emailtoken SET member_name=member_id;emailtoken
-- UPDATE emailtoken A INNER JOIN member B ON A.member_id = B.member_id SET 
-- UPDATE emailtoken SET member_id = (SELECT member_id FROM member WHERE emailtoken.member_id=member.member_name limit 1)

-- alter table board rename column name to member_name;
-- ALTER TABLE board modify board_id bigint not null auto_increment;