USE `proyectop312023` ;
alter table tbl_bancoExterno add estatus varchar(1) not null;
alter table tbl_tipoPersonaBancos modify tipPerEstatus varchar(15) not null;

-- Agregar clave foránea a las tablas que contienen el campo "cueTipoId"
-- Tabla: tbl_cuentasBancos
ALTER TABLE tbl_cuentasBancos ADD CONSTRAINT FK_cueTipoId_cuentasBancos
FOREIGN KEY (cueTipoId) REFERENCES tbl_tipoCuentasBancos(cueTipoId);

-- Cambiar campo por llave foránea
-- Primero, eliminamos la columna tipoCuentaEm
ALTER TABLE tbl_cuentaEmpresaBancos DROP COLUMN tipoCuentaEm;
-- Luego, agregamos la columna cueTipoId
ALTER TABLE tbl_cuentaEmpresaBancos ADD cueTipoId INT(5) NOT NULL;
-- A continuación, agregamos la clave foránea
ALTER TABLE tbl_cuentaEmpresaBancos ADD CONSTRAINT FK_cueTipoId_cuentaEmpresaBancos
FOREIGN KEY (cueTipoId) REFERENCES tbl_tipoCuentasBancos(cueTipoId);

