-- public.categorias definition

-- Drop table

-- DROP TABLE public.categorias;

CREATE TABLE public.categorias (
	nombre varchar(30) NOT NULL,
	descripcion varchar(50) NULL,
	
	CONSTRAINT categorias_pkey PRIMARY KEY (nombre)
);

---------------------------------------------------------------------------------------------------------------------------------

-- public.productos definition

-- Drop table

-- DROP TABLE public.productos;

CREATE TABLE public.productos (
	id serial NOT NULL,
	categoria varchar(30) NULL,
	nombre varchar(30) NULL,
	precio int4 NULL,
	descripcion varchar(50) NULL,
	puntaje int4 NULL,
	cantidad int4 NULL,
	
	CONSTRAINT productos_pkey PRIMARY KEY (id)
);


-- public.productos foreign keys

ALTER TABLE public.productos ADD CONSTRAINT fk_productos_categorias FOREIGN KEY (categoria) REFERENCES public.categorias(nombre) ON DELETE CASCADE ON UPDATE CASCADE;

---------------------------------------------------------------------------------------------------------------------------------

-- public.rol definition

-- Drop table

-- DROP TABLE public.rol;

CREATE TABLE public.rol (
	id serial NOT NULL,
	nombre varchar NOT NULL,
	descripcion varchar NOT NULL,
	
	CONSTRAINT rol_pk PRIMARY KEY (id)
);

---------------------------------------------------------------------------------------------------------------------------------

-- public.usuarios definition

-- Drop table

-- DROP TABLE public.usuarios;

CREATE TABLE public.usuarios (
	username varchar(20) NOT NULL,
	documento int4 NULL,
	telefono varchar(20) NULL,
	email varchar(100) NULL,
	nombre varchar(50) NULL,
	edad int4 NULL,
	"password" varchar(260) NULL,
	direccion varchar(40) NULL,
	tipodocumento varchar(10) NULL,
	rol int4 NOT NULL,
	
	CONSTRAINT usuarios_documento_key UNIQUE (documento),
	CONSTRAINT usuarios_pkey PRIMARY KEY (username),
	CONSTRAINT usuarios_telefono_key UNIQUE (telefono)
);


-- public.usuarios foreign keys

ALTER TABLE public.usuarios ADD CONSTRAINT usuarios_fk FOREIGN KEY (rol) REFERENCES public.rol(id) ON DELETE CASCADE ON UPDATE CASCADE;

---------------------------------------------------------------------------------------------------------------------------------

-- public.imagenes definition

-- Drop table

-- DROP TABLE public.imagenes;

CREATE TABLE public.imagenes (
	id serial NOT NULL,
	producto int4 NOT NULL,
	imagen bytea NOT NULL,
	
	CONSTRAINT imagenes_pk PRIMARY KEY (id)
);


-- public.imagenes foreign keys

ALTER TABLE public.imagenes ADD CONSTRAINT imagenes_productos_fk FOREIGN KEY (producto) REFERENCES public.productos(id) ON DELETE CASCADE ON UPDATE CASCADE;

---------------------------------------------------------------------------------------------------------------------------------

-- public.compras definition

-- Drop table

-- DROP TABLE public.compras;

CREATE TABLE public.compras (
	usuario varchar(20) NOT NULL,
	producto int4 NOT NULL,
	cantidad int4 NULL,
	
	CONSTRAINT compras_pkey PRIMARY KEY (usuario, producto)
);


-- public.compras foreign keys

ALTER TABLE public.compras ADD CONSTRAINT fk_compras_productos FOREIGN KEY (producto) REFERENCES public.productos(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE public.compras ADD CONSTRAINT fk_compras_usuarios FOREIGN KEY (usuario) REFERENCES public.usuarios(username) ON DELETE CASCADE ON UPDATE CASCADE;

---------------------------------------------------------------------------------------------------------------------------------

-- public.carrito_compras definition

-- Drop table

-- DROP TABLE public.carrito_compras;

CREATE TABLE public.carrito_compras (
	usuario varchar(20) NOT NULL,
	producto int4 NOT NULL,
	cantidad int4 NULL,
	
	CONSTRAINT carrito_compras_pkey PRIMARY KEY (usuario, producto)
);


-- public.carrito_compras foreign keys

ALTER TABLE public.carrito_compras ADD CONSTRAINT fk_carritocompras_productos FOREIGN KEY (producto) REFERENCES public.productos(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE public.carrito_compras ADD CONSTRAINT fk_carritocompras_usuarios FOREIGN KEY (usuario) REFERENCES public.usuarios(username) ON DELETE CASCADE ON UPDATE CASCADE;

---------------------------------------------------------------------------------------------------------------------------------

-- public.favoritos definition

-- Drop table

-- DROP TABLE public.favoritos;

CREATE TABLE public.favoritos (
	usuario varchar(20) NOT NULL,
	producto int4 NOT NULL,
	
	CONSTRAINT favoritos_pkey PRIMARY KEY (usuario, producto)
);


-- public.favoritos foreign keys

ALTER TABLE public.favoritos ADD CONSTRAINT fk_favoritos_productos FOREIGN KEY (producto) REFERENCES public.productos(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE public.favoritos ADD CONSTRAINT fk_favoritos_usuarios FOREIGN KEY (usuario) REFERENCES public.usuarios(username) ON DELETE CASCADE ON UPDATE CASCADE;

---------------------------------------------------------------------------------------------------------------------------------

-- public.comentarios definition

-- Drop table

-- DROP TABLE public.comentarios;

CREATE TABLE public.comentarios (
	usuario varchar(20) NULL,
	producto int4 NULL,
	contenido varchar(40) NULL
);


-- public.comentarios foreign keys

ALTER TABLE public.comentarios ADD CONSTRAINT fk_comentaios_productos FOREIGN KEY (producto) REFERENCES public.productos(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE public.comentarios ADD CONSTRAINT fk_comentarios_usuarios FOREIGN KEY (usuario) REFERENCES public.usuarios(username) ON DELETE CASCADE ON UPDATE CASCADE;

---------------------------------------------------------------------------------------------------------------------------------

-- public.mensajes definition

-- Drop table

-- DROP TABLE public.mensajes;

CREATE TABLE public.mensajes (
	id serial NOT NULL,
	emisor varchar(20) NULL,
	receptor varchar(20) NULL,
	fecha date NULL,
	contenido varchar(50) NULL,
	visto bool NULL,
	
	CONSTRAINT mensajes_pkey PRIMARY KEY (id)
);


-- public.mensajes foreign keys

ALTER TABLE public.mensajes ADD CONSTRAINT fk_mensajes_usuarios FOREIGN KEY (emisor) REFERENCES public.usuarios(username) ON DELETE CASCADE ON UPDATE CASCADE;

---------------------------------------------------------------------------------------------------------------------------------
