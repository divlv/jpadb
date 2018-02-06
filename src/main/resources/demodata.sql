DROP TABLE IF EXISTS demo_data;
DROP SEQUENCE IF EXISTS demo_data_id_seq;

CREATE TABLE demo_data (
    id int PRIMARY KEY NOT NULL,
    name varchar (50)
);

CREATE INDEX demo_data_id ON demo_data(id);

CREATE SEQUENCE demo_data_id_seq MINVALUE 1;
--Alter the default of the column to use the sequence
ALTER TABLE demo_data ALTER id SET DEFAULT nextval('demo_data_id_seq');
--Alter the sequence to be owned by the table/column;
ALTER SEQUENCE demo_data_id_seq OWNED BY demo_data.id;

insert into demo_data (name) values ('John');
insert into demo_data (name) values ('Paul');
insert into demo_data (name) values ('George');
insert into demo_data (name) values ('Ringo');

GRANT ALL ON ALL TABLES IN SCHEMA public to testuser;
GRANT ALL ON ALL SEQUENCES IN SCHEMA public to testuser;