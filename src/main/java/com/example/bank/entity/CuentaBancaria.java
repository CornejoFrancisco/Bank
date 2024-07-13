package com.example.bank.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "cuenta_bancaria")
public abstract class CuentaBancaria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double dni;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String email;
    private double saldo;
    private String tipo;


    public void depositar(double monto) {
        if(monto > 0){
            saldo += monto;
        }else{
            System.out.println("El monto a depositar debe ser mayor a 0");
        }
    }

    public void retirar(double monto) {
        if(monto > 0){
            if(saldo >= monto){
                saldo -= monto;
            }else{
                System.out.println("Saldo insuficiente");
            }
        }else{
            System.out.println("El monto a retirar debe ser mayor a 0");
        }
    }

    public void transferir(CuentaBancaria cuentaDestino, double monto) {
        if(monto > 0){
            if(saldo >= monto){
                saldo -= monto;
                cuentaDestino.depositar(monto);
            }else{
                System.out.println("Saldo insuficiente");
            }
        }else{
            System.out.println("El monto a transferir debe ser mayor a 0");
        }
    }

    public double mostrarSaldo() {
        double saldo = this.saldo;
        System.out.println("Saldo: " + saldo);
        return saldo;
    }

}
