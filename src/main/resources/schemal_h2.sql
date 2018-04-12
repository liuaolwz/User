create table TB_USER
(
  ID             NUMBER not null PRIMARY KEY,
  NAME           VARCHAR2(20) not null,
  AGE            INTEGER not null,
  GENDER         NUMBER not null,
  CREATE_TIME    TIMESTAMP
);
create sequence SEQ_USER_ID
minvalue 1
maxvalue 999999
start with 20
increment by 1
cache 20;