use spring;

insert into role(id,name) value(1,"ROLE_USER");
insert into role(id,name) value(2,"ROLE_ADMIN");


insert into user_roles(user_id,roles_id) value(1,2);

insert into category(id_of_category, name) value (1, "Fasion and Style");
insert into category(id_of_category, name) value (2, "Electronic");
insert into category(id_of_category, name) value (3, "Auto");

insert into sub_category(id_of_sub_category, name) value (1, "accessories");
insert into sub_category(id_of_sub_category, name) value (2, "men wears");
insert into sub_category(id_of_sub_category, name) value (3, "women wears");
insert into sub_category(id_of_sub_category, name) value (4, "Smartphone");
insert into sub_category(id_of_sub_category, name) value (5, "Home Appliances");
insert into sub_category(id_of_sub_category, name) value (6, "Pc parts");
insert into sub_category(id_of_sub_category, name) value (7, "cars");
insert into sub_category(id_of_sub_category, name) value (8, "moto");
insert into sub_category(id_of_sub_category, name) value (9, "special");