-- public.categorias definition

-- Drop table

-- DROP TABLE categorias;

CREATE TABLE categorias
(
    nombre      varchar(30) NOT NULL,
    descripcion varchar(500) NULL,
    CONSTRAINT categorias_pkey PRIMARY KEY (nombre)
);


-- public.rol definition

-- Drop table

-- DROP TABLE rol;

CREATE TABLE rol
(
    id          serial  NOT NULL,
    nombre      varchar NOT NULL,
    descripcion varchar NOT NULL,
    CONSTRAINT rol_pk PRIMARY KEY (id)
);


-- public.productos definition

-- Drop table

-- DROP TABLE productos;

CREATE TABLE productos
(
    id          serial NOT NULL,
    categoria   varchar(30) NULL,
    nombre      varchar(30) NULL,
    precio      int4 NULL,
    descripcion varchar(50) NULL,
    puntaje     int4 NULL,
    cantidad    int4 NULL,
    CONSTRAINT productos_pkey PRIMARY KEY (id),
    CONSTRAINT fk_productos_categorias FOREIGN KEY (categoria) REFERENCES categorias (nombre) ON UPDATE CASCADE ON DELETE CASCADE
);


-- public.usuarios definition

-- Drop table

-- DROP TABLE usuarios;

CREATE TABLE usuarios
(
    username      varchar(20) NOT NULL,
    documento     int4 NULL,
    telefono      varchar(20) NULL,
    email         varchar(100) NULL,
    nombre        varchar(50) NULL,
    edad          int4 NULL,
    "password"    varchar(260) NULL,
    direccion     varchar(40) NULL,
    tipodocumento varchar(10) NULL,
    rol           int4        NOT NULL,
    CONSTRAINT usuarios_documento_key UNIQUE (documento),
    CONSTRAINT usuarios_pkey PRIMARY KEY (username),
    CONSTRAINT usuarios_telefono_key UNIQUE (telefono),
    CONSTRAINT usuarios_fk FOREIGN KEY (rol) REFERENCES rol (id) ON UPDATE CASCADE ON DELETE CASCADE
);


-- public.carrito_compras definition

-- Drop table

-- DROP TABLE carrito_compras;

CREATE TABLE carrito_compras
(
    usuario  varchar(20) NOT NULL,
    producto int4        NOT NULL,
    cantidad int4 NULL,
    CONSTRAINT carrito_compras_pkey PRIMARY KEY (usuario, producto),
    CONSTRAINT fk_carritocompras_productos FOREIGN KEY (producto) REFERENCES productos (id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_carritocompras_usuarios FOREIGN KEY (usuario) REFERENCES usuarios (username) ON UPDATE CASCADE ON DELETE CASCADE
);


-- public.comentarios definition

-- Drop table

-- DROP TABLE comentarios;

CREATE TABLE comentarios
(
    usuario   varchar(20) NULL,
    producto  int4 NULL,
    contenido varchar(40) NULL,
    CONSTRAINT fk_comentaios_productos FOREIGN KEY (producto) REFERENCES productos (id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_comentarios_usuarios FOREIGN KEY (usuario) REFERENCES usuarios (username) ON UPDATE CASCADE ON DELETE CASCADE
);


-- public.compras definition

-- Drop table

-- DROP TABLE compras;

CREATE TABLE compras
(
    usuario  varchar(20) NOT NULL,
    producto int4        NOT NULL,
    cantidad int4 NULL,
    CONSTRAINT compras_pkey PRIMARY KEY (usuario, producto),
    CONSTRAINT fk_compras_productos FOREIGN KEY (producto) REFERENCES productos (id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_compras_usuarios FOREIGN KEY (usuario) REFERENCES usuarios (username) ON UPDATE CASCADE ON DELETE CASCADE
);


-- public.favoritos definition

-- Drop table

-- DROP TABLE favoritos;

CREATE TABLE favoritos
(
    usuario  varchar(20) NOT NULL,
    producto int4        NOT NULL,
    CONSTRAINT favoritos_pkey PRIMARY KEY (usuario, producto),
    CONSTRAINT fk_favoritos_productos FOREIGN KEY (producto) REFERENCES productos (id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_favoritos_usuarios FOREIGN KEY (usuario) REFERENCES usuarios (username) ON UPDATE CASCADE ON DELETE CASCADE
);


-- public.imagenes definition

-- Drop table

-- DROP TABLE imagenes;

CREATE TABLE imagenes
(
    id       serial       NOT NULL,
    producto int4         NOT NULL,
    url      varchar(500) NOT NULL,
    CONSTRAINT imagenes_pk PRIMARY KEY (id),
    CONSTRAINT imagenes_productos_fk FOREIGN KEY (producto) REFERENCES productos (id) ON UPDATE CASCADE ON DELETE CASCADE
);


-- public.mensajes definition

-- Drop table

-- DROP TABLE mensajes;

CREATE TABLE mensajes
(
    id        serial NOT NULL,
    emisor    varchar(20) NULL,
    receptor  varchar(20) NULL,
    fecha     date NULL,
    contenido varchar(50) NULL,
    visto     bool NULL,
    CONSTRAINT mensajes_pkey PRIMARY KEY (id),
    CONSTRAINT fk_mensajes_usuarios FOREIGN KEY (emisor) REFERENCES usuarios (username) ON UPDATE CASCADE ON DELETE CASCADE
);