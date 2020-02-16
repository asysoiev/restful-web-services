insert into USER(id, name, birth_date)
values (NEXTVAL('hibernate_sequence'), 'John', DATEADD('YEAR', -1, CURRENT_DATE));
insert into USER(id, name, birth_date)
values (NEXTVAL('hibernate_sequence'), 'Jill', DATEADD('YEAR', -2, CURRENT_DATE));
insert into USER(id, name, birth_date)
values (NEXTVAL('hibernate_sequence'), 'Abby', DATEADD('YEAR', -3, CURRENT_DATE));