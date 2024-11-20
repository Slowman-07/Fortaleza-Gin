create database ginart;

use ginart;

create table usuarios (
user_name varchar(30) not null,
user_pass varchar(30) not null
);

ALTER TABLE usuarios auto_increment=1; -- (reiniciar primary key id)

drop table usuarios; -- (borrar tabla completa) 

insert into usuarios (user_name, user_pass) values ("nombre", "clave"); -- (agregar usuario)

create table producto (
idproducto int auto_increment not null primary key,
nombre varchar(100),
precioProducto decimal (5,2),
stock int
);

ALTER TABLE producto auto_increment=1; -- (reiniciar primary key id)

drop table producto; -- (borrar tabla completa) 

create table cliente(
idcliente int auto_increment not null primary key,
nombre varchar(100),
apellido varchar(100),
domicilio varchar(100),
correo varchar(100)
);

ALTER TABLE cliente auto_increment=1; -- (reiniciar primary key id)

drop table cliente; -- (borrar tabla completa)

create table factura (
idfactura int auto_increment not null primary key,
fechaFactura date,
fkcliente int,
foreign key (fkcliente) references cliente(idcliente)
);

ALTER TABLE factura auto_increment=1; -- (reiniciar primary key id)

drop table factura; -- (borrar tabla completa)

create table detalle (
iddetalle int auto_increment not null primary key,
fkfactura int,
foreign key (fkfactura) references factura(idfactura),
fkproducto int,
foreign key (fkproducto) references producto(idproducto),
cantidad int,
precioVenta decimal(10,2)
);

ALTER TABLE detalle auto_increment=1; -- (reiniciar primary key id)

drop table detalle; -- (borrar tabla completa)

DESCRIBE producto; -- (muestra descripcion de tabla)

ALTER TABLE producto MODIFY COLUMN precioProducto DECIMAL(10,2); -- (modificar valor de columna)

ALTER TABLE detalle MODIFY COLUMN precioVenta DECIMAL(10,2);

DESCRIBE detalle;

ALTER TABLE factura DROP FOREIGN KEY factura_ibfk_1;

