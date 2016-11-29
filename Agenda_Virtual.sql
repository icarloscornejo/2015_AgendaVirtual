create database Agenda_Virtual

use Agenda_Virtual
go

create table Usuarios(
cod_usu int not null primary key,
nom_usu varchar(100),
ape_usu varchar(100),
sex_usu varchar(100),
fecnac_usu datetime,
correo_usu varchar(100),
usu_usu varchar(100),
contra_usu varchar(100),
)

create table Actividades(
cod_act int not null primary key,
nom_act varchar(100),
des_act varchar(300),
fecha_act datetime,
hora_act time,
lugar_act varchar(100),
estado_act int,
cod_usu int not null,
foreign key (cod_usu) references Usuarios(cod_usu) on delete cascade on update cascade
id_tipoact int not null
foreign key (id_tipoact) references Tipo_Actividades(id_tipoact) on delete cascade on update cascade
)

create table Notas(
cod_nota int not null primary key,
nom_nota varchar(100),
des_nota varchar(100),
fechcreacion_nota datetime,
estado_nota binary,
cod_usu int not null,
foreign key (cod_usu) references Usuarios(cod_usu) on delete cascade on update cascade
)

create table Contactos(
cod_contacto int not null primary key,
nom_contacto varchar(100),
ape_contacto varchar(100),
sex_contacto varchar(100),
fecnac_contacto varchar(100),
correo_contacto varchar(100),
cod_usu int not null,
foreign key (cod_usu) references Usuarios(cod_usu) on delete cascade on update cascade
)

create table Tipo_Actividades(
id_tipoact int not null primary key,
nom_tipoact varchar(100)
)

