INSERT INTO savingDb.cuentas(estado, account_id, cliente_id, numero_cuenta, saldo_actual, saldo_inicial, tipo_cuenta)VALUES(1, 1, 1, 478758, 2000, 2000, 'A');
INSERT INTO savingDb.cuentas(estado, account_id, cliente_id, numero_cuenta, saldo_actual, saldo_inicial, tipo_cuenta)VALUES(1, 2, 2, 225487, 100, 100, 'C');
INSERT INTO savingDb.cuentas(estado, account_id, cliente_id, numero_cuenta, saldo_actual, saldo_inicial, tipo_cuenta)VALUES(1, 3, 3, 495878, 0, 0, 'A');
INSERT INTO savingDb.cuentas(estado, account_id, cliente_id, numero_cuenta, saldo_actual, saldo_inicial, tipo_cuenta)VALUES(1, 4, 2, 496825, 540, 540, 'A');



INSERT INTO savingDb.movimientos(cuenta_id, fecha, movimiento_id, saldo, valor, tipo_movimiento)VALUES(1,'10/2/2022', 225487, 100, 600, 'D');
INSERT INTO savingDb.movimientos(cuenta_id, fecha, movimiento_id, saldo, valor, tipo_movimiento)VALUES(2,'18/2/2022', 496825, 540, -540, 'R');

