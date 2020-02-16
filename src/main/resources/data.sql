insert into USER(id, name, birth_date)
values (NEXTVAL('user_id_seq'), 'John', DATEADD('YEAR', -1, CURRENT_DATE));
insert into POST(id, description, user_id)
values (NEXTVAL('post_id_seq'), 'My first post', CURRVAL('user_id_seq'));
insert into POST(id, description, user_id)
values (NEXTVAL('post_id_seq'), 'My second post', CURRVAL('user_id_seq'));

insert into USER(id, name, birth_date)
values (NEXTVAL('user_id_seq'), 'Jill', DATEADD('YEAR', -2, CURRENT_DATE));

insert into USER(id, name, birth_date)
values (NEXTVAL('user_id_seq'), 'Abby', DATEADD('YEAR', -3, CURRENT_DATE));