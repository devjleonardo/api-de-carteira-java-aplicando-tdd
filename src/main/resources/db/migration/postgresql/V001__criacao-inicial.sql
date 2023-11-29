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
  usuario   integer,
  carteira  integer,
  primary key (id),
  foreign key (usuario) references usuario (id),
  foreign key (carteira) references carteira (id)
);

create table carteira_itens (
  id         serial,
  carteira   integer,
  data       date,
  tipo       varchar(2),
  descricao  varchar(500),
  valor      numeric(10,2),
  primary key (id),
  foreign key (carteira) references carteira (id)
);