USE `proyectop312023` ;
alter table tbl_bancoExterno add estatus varchar(1) not null;
alter table tbl_tipoPersonaBancos modify tipPerEstatus varchar(15) not null;