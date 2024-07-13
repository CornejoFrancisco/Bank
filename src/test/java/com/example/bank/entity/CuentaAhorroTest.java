package com.example.bank.entity;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CuentaAhorroTest {

    @Test
    void testDepositar() {
        CuentaAhorro cuenta = new CuentaAhorro();
        cuenta.depositar(100);
        assertEquals(100, cuenta.getSaldo());
    }

    @Test
    void testDepositarMontoNegativo() {
        CuentaAhorro cuenta = new CuentaAhorro();
        cuenta.depositar(-50);
        assertEquals(0, cuenta.getSaldo());
    }

    @Test
    void testTransferir() {
        CuentaAhorro cuenta1 = new CuentaAhorro();
        CuentaAhorro cuenta2 = new CuentaAhorro();
        cuenta1.depositar(100);
        cuenta1.transferir(cuenta2, 50);
        assertEquals(50, cuenta1.getSaldo());
        assertEquals(50, cuenta2.getSaldo());
    }

    @Test
    void testTransferirSaldoInsuficiente() {
        CuentaAhorro cuenta1 = new CuentaAhorro();
        CuentaAhorro cuenta2 = new CuentaAhorro();
        cuenta1.depositar(30);
        cuenta1.transferir(cuenta2, 50);
        assertEquals(30, cuenta1.getSaldo());
        assertEquals(0, cuenta2.getSaldo());
    }
}

