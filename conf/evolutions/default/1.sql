# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table tbCurriculum (
  cu_id                     varchar(13) not null,
  name_th                   varchar(255),
  name_en                   varchar(255),
  short_name                varchar(255),
  status                    varchar(255),
  year                      integer,
  director                  varchar(255),
  academic_approve          timestamp,
  council_approve           timestamp,
  high_edu_approve          timestamp,
  department                varchar(255),
  faculty                   varchar(255),
  university                varchar(255),
  place                     varchar(255),
  constraint pk_tbCurriculum primary key (cu_id))
;

create sequence tbCurriculum_seq;




# --- !Downs

drop table if exists tbCurriculum cascade;

drop sequence if exists tbCurriculum_seq;

