/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     6/23/2022 5:14:09 PM                         */
/*==============================================================*/


drop table if exists ADMINISTRADOR;

drop table if exists CITAS;

drop table if exists EXAMENES;

drop table if exists ANTECEDENTES;

drop table if exists PACIENTES;

drop table if exists HORARIO;

drop table if exists MEDICOS;

drop table if exists CIUDADES;

drop table if exists ESPECIALIDAD;

/*==============================================================*/
/* Table: ADMINISTRADOR                                         */
/*==============================================================*/
create table ADMINISTRADOR
(
   ID                   int not null auto_increment,
   NOMBRE               varchar(20),
   CORREO               varchar(50),
   PASSWORD             varchar(50),
   primary key (ID)
);

/*==============================================================*/
/* Table: ANTECEDENTES                                          */
/*==============================================================*/
create table ANTECEDENTES
(
   ID                   int not null auto_increment,
   ID_PACIENTE          int,
   ENFERMEDADES         varchar(250),
   ALERGIAS             varchar(250),
   CIRUGIAS             varchar(250),
   primary key (ID)
);

/*==============================================================*/
/* Table: CITAS                                                 */
/*==============================================================*/
create table CITAS
(
   ID                   int not null auto_increment,
   ID_PACIENTES         int,
   ID_MEDICOS           int,
   ESTADO               varchar(20),
   FECHA                datetime,
   ANOTACIONES          varchar(200),
   primary key (ID)
);

/*==============================================================*/
/* Table: CIUDADES                                              */
/*==============================================================*/
create table CIUDADES
(
   ID                   int not null auto_increment,
   NOMBRE               varchar(20),
   primary key (ID)
);

/*==============================================================*/
/* Table: ESPECIALIDAD                                          */
/*==============================================================*/
create table ESPECIALIDAD
(
   ID                   int not null auto_increment,
   NOMBRE               varchar(50),
   primary key (ID)
);

/*==============================================================*/
/* Table: EXAMENES                                              */
/*==============================================================*/
create table EXAMENES
(
   ID                   int not null auto_increment,
   ID_PACIENTE          int,
   NOMBRE               varchar(50),
   TIPO                 varchar(20),
   FILE                 longblob,
   primary key (ID)
);

/*==============================================================*/
/* Table: HORARIO                                               */
/*==============================================================*/
create table HORARIO
(
   ID                   int not null auto_increment,
   ID_MEDICOS           int,
   DIA                  int,
   HORAENTRADA          int,
   HORASALIDA           int,
   FRECUENCIA           int,
   primary key (ID)
);

/*==============================================================*/
/* Table: MEDICOS                                               */
/*==============================================================*/
create table MEDICOS
(
   ID                   int not null auto_increment,
   ID_ESPECIALIDAD      int,
   ID_CIUDAD            int,
   NOMBRE               varchar(20),
   CORREO               varchar(50),
   PASSWORD             varchar(50),
   PRESENTACION         varchar(200),
   ESTADO               varchar(20),
   COSTO                varchar(50),
   FOTO                 longblob,
   primary key (ID)
);

/*==============================================================*/
/* Table: PACIENTES                                             */
/*==============================================================*/
create table PACIENTES
(
   ID                   int not null auto_increment,
   ID_MEDICO            int,
   NOMBRE               varchar(20),
   CORREO               varchar(50),
   SANGRE               varchar(50),
   GENERO               varchar(20),
   FECHA                date,
   primary key (ID)
);

alter table ANTECEDENTES add constraint FK_REFERENCE_8 foreign key (ID_PACIENTE)
      references PACIENTES (ID) on delete restrict on update restrict;

alter table CITAS add constraint FK_REFERENCE_1 foreign key (ID_PACIENTES)
      references PACIENTES (ID) on delete restrict on update restrict;

alter table CITAS add constraint FK_REFERENCE_2 foreign key (ID_MEDICOS)
      references MEDICOS (ID) on delete restrict on update restrict;

alter table EXAMENES add constraint FK_REFERENCE_9 foreign key (ID_PACIENTE)
      references PACIENTES (ID) on delete restrict on update restrict;

alter table HORARIO add constraint FK_REFERENCE_5 foreign key (ID_MEDICOS)
      references MEDICOS (ID) on delete restrict on update restrict;

alter table MEDICOS add constraint FK_REFERENCE_3 foreign key (ID_ESPECIALIDAD)
      references ESPECIALIDAD (ID) on delete restrict on update restrict;

alter table MEDICOS add constraint FK_REFERENCE_4 foreign key (ID_CIUDAD)
      references CIUDADES (ID) on delete restrict on update restrict;

alter table PACIENTES add constraint FK_REFERENCE_7 foreign key (ID_MEDICO)
      references MEDICOS (ID) on delete restrict on update restrict;

