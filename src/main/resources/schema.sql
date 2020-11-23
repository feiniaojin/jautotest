create table t_item
(

    id          bigint auto_increment COMMENT '自动增长id',

    item_name   varchar(10) not null default '' COMMENT 'item名称',

    item_count  int         not null default 0 COMMENT '姓名',

    create_time DATETIME    not null COMMENT '创建时间',
    PRIMARY KEY (id)
);