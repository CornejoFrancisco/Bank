package com.example.bank.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity

public class CuentaAhorro extends CuentaBancaria {

    private double saldoCuentaBancario;
    private String tipoCuenta = "Ahorro";

    public CuentaAhorro() {
        super();
    }

    @Override
    public void depositar(double monto) {
        if (monto > 0) {
            saldoCuentaBancario += monto;
        } else {
            System.out.println("El monto a depositar debe ser mayor a 0");
        }
    }

    @Override
    public void transferir(CuentaBancaria cuentaDestino, double monto) {
        if (monto > 0) {
            if (saldoCuentaBancario >= monto) {
                saldoCuentaBancario -= monto;
                cuentaDestino.depositar(monto);
            } else {
                System.out.println("Saldo insuficiente para realizar la transferencia");
            }
        } else {
            System.out.println("El monto a transferir debe ser mayor a 0");
        }
    }

    @Override
    public double mostrarSaldo() {
        return saldoCuentaBancario;
    }

    public double getSaldo() {
        return saldoCuentaBancario;
    }

    public void setSaldo(double saldoCuentaBancario) {
        this.saldoCuentaBancario = saldoCuentaBancario;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }
}
