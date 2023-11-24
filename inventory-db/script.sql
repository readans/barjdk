-- Crear la tabla SEDE
create table sede (
  pk_sede_id int auto_increment primary key,
  direccion_sede varchar(100) not null
);

-- Crear la tabla ROL
create table rol (
  pk_rol_id int auto_increment primary key,
  nombre varchar(100) not null
);

-- Crear la tabla EMPLEADO
create table empleado (
  pk_empleado_id int auto_increment primary key,
  fk_rol_id int not null,
  fk_sede_id int not null,
  documento varchar(20) not null,
  nombre varchar(50) not null,
  apellido varchar(50) not null,
  usuario_acceso varchar(50) not null,
  clave_acceso varchar(255) not null,
  constraint fk_rol_id foreign key (fk_rol_id) references rol(pk_rol_id),
  constraint fk_sede_id foreign key (fk_sede_id) references sede(pk_sede_id)
);

-- Crear la tabla MESA
create table mesa (
  pk_mesa_id int auto_increment primary key,
  estado int not null
);

-- Crear la tabla PEDIDO
create table pedido (
  pk_pedido_id int auto_increment primary key,
  fk_empleado_id int not null,
  fk_mesa_id int not null,
  constraint fk_empleado_id foreign key (fk_empleado_id) references empleado(pk_empleado_id),
  constraint fk_mesa_id foreign key (fk_mesa_id) references mesa(pk_mesa_id)
);

-- Crear la tabla PAGO
create table pago (
  pk_pago_id int auto_increment primary key,
  fk_pedido_id int not null,
  valor int not null,
  constraint fk_pedido_id foreign key (fk_pedido_id) references pedido(pk_pedido_id)
);

-- Crear la tabla PRODUCTO
create table producto (
  pk_producto_id int auto_increment primary key,
  descripcion varchar(100) not null,
  valor int not null,
  cantidad int not null
);

-- Crear la tabla DETALLE_PEDIDO
create table detalle_pedido (
  pk_detalle_pedido_id int auto_increment primary key,
  fk_pedido_id int not null,
  fk_producto_id int not null,
  cantidad int not null,
  constraint fk_pedidoo_id foreign key (fk_pedido_id) references pedido(pk_pedido_id),
  constraint fk_producto_id foreign key (fk_producto_id) references producto(pk_producto_id)
);

DELIMITER //
CREATE TRIGGER after_insert_detalle_pedido
AFTER INSERT ON detalle_pedido
FOR EACH ROW
BEGIN
    UPDATE producto SET cantidad = cantidad - NEW.cantidad WHERE pk_producto_id = NEW.fk_producto_id;
END;
//
DELIMITER ;after_insert_detalle_pedido


-- Crear la tabla PERMISO
create table permiso (
	pk_permiso_id int auto_increment primary key,
    nombre_permiso varchar(100) not null,
    descripcion_permiso varchar(100) not null
);

-- Crear la tabla PERMISO_ROL
create table permiso_rol (
	pk_permiso_rol_id int auto_increment primary key,
    fk_permiso_id int not null,
    fk_rol_id int not null,
	constraint fk_permiso_id foreign key (fk_permiso_id) references permiso(pk_permiso_id),
	constraint fk_roll_id foreign key (fk_rol_id) references rol(pk_rol_id)
);
