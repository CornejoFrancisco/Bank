package com.example.bank.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class CuentaCorriente extends CuentaBancaria{
    private double saldoCuentaBancario;

    @Override
    public void depositar(double monto) {
        if(monto > 0){
            saldoCuentaBancario += monto;
        }else{
            System.out.println("El monto a depositar debe ser mayor a 0");
        }
    }
    @Override
    public void transferir(CuentaBancaria cuentaDestino, double monto) {
        if(monto > 0){
            if(saldoCuentaBancario >= monto){
                saldoCuentaBancario -= monto;
                cuentaDestino.depositar(monto);
            }else{
                System.out.println("Saldo insuficiente para realizar la transferencia");
            }
        }else{
            System.out.println("El monto a transferir debe ser mayor a 0");
        }
    }

    @Override
    public void retirar(double monto) {
        if(monto > 0){
            if(saldoCuentaBancario >= monto){
                saldoCuentaBancario -= monto;
            }else{
                System.out.println("Saldo insuficiente para realizar el retiro");
            }
        }else{
            System.out.println("El monto a retirar debe ser mayor a 0");
        }
    }

    @Override
    public double mostrarSaldo() {
        return saldoCuentaBancario;
    }


}
