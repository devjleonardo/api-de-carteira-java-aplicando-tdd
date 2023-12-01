create table usuario (
  id     serial,
  nome   varchar(50),
  email  varchar(100),
  senha  varchar,
  primary key (id)
);


create table carteira (
  id     serial,
  nome   varchar(60),
  valor  numeric(10,2),
  primary key (id)
);

create table usuario_carteira (
  id        serial,
  usuario_id   integer,
  carteira_id  integer,
  primary key (id),
  foreign key (usuario_id) references usuario (id),
  foreign key (carteira_id) references carteira (id)
);

create table item_carteira (
  id         serial,
  carteira   integer,
  data       date,
  tipo       varchar(2),
  descricao  varchar(500),
  valor      numeric(10,2),
  primary key (id),
  foreign key (carteira) references carteira (id)
);