drop table if exists thing CASCADE 
create table thing (id bigint generated by default as identity, description varchar(255), name varchar(255) not null, priority varchar(255), primary key (id))