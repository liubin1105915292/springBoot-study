-- Create table
create table E_USER_BIND_TEMP
(
  band_id        NUMBER(10) not null,
  user_id        NUMBER(10) not null,
  extend_type    NUMBER(3) not null,
  extend_id      VARCHAR2(50),
  extend_time    DATE default sysdate,
  status         CHAR(1),
  attention_time DATE,
  biz_channel    NUMBER(3) default 1 not null,
  user_type      NUMBER(2),
  nickname       VARCHAR2(50)
);
-- Add comments to the table 
comment on table E_USER_BIND_TEMP
  is '外部用户绑定表';
-- Add comments to the columns 
comment on column E_USER_BIND_TEMP.band_id
  is '绑定ID';
comment on column E_USER_BIND_TEMP.user_id
  is '用户ID';
comment on column E_USER_BIND_TEMP.extend_type
  is '外部渠道类型';
comment on column E_USER_BIND_TEMP.extend_id
  is '微信号';
comment on column E_USER_BIND_TEMP.extend_time
  is '绑定时间';
comment on column E_USER_BIND_TEMP.status
  is '绑定状态（0：无效，1：有效，2：临时）';
comment on column E_USER_BIND_TEMP.attention_time
  is '关注时间';
comment on column E_USER_BIND_TEMP.biz_channel
  is '渠道来源  1 :微信 ,  2: 触点';
comment on column E_USER_BIND_TEMP.user_type
  is '用户状态  1 有效   2 临时';
comment on column E_USER_BIND_TEMP.nickname
  is '昵称';