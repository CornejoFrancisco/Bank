package com.example.bank.service;


import com.example.bank.entity.CuentaBancaria;
import com.example.bank.repository.CuentaBancariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuentaBancariaService {

    @Autowired
    private CuentaBancariaRepository cuentaBancariaRepository;


    public CuentaBancaria crearCuentaBancaria(CuentaBancaria cuentaBancaria){
        return cuentaBancariaRepository.save(cuentaBancaria);
    }

    public CuentaBancaria obtenerCuentaBancariaPorDni(double dni){
        return cuentaBancariaRepository.findByDni(dni).orElse(null);
    }

    public void eliminarCuentaBancariaPorDni(double dni){
        cuentaBancariaRepository.deleteByDni(dni);
    }

    public void depositar(double dni, double monto){
        CuentaBancaria cuentaBancaria = obtenerCuentaBancariaPorDni(dni);
        if(cuentaBancaria != null){
            cuentaBancaria.depositar(monto);
            cuentaBancariaRepository.save(cuentaBancaria);
        }
    }

    public void retirar(double dni, double monto){
        CuentaBancaria cuentaBancaria = obtenerCuentaBancariaPorDni(dni);
        if(cuentaBancaria != null){
            cuentaBancaria.retirar(monto);
            cuentaBancariaRepository.save(cuentaBancaria);
        }
    }

    public void transferir(double dniOrigen, double dniDestino, double monto){
        CuentaBancaria cuentaOrigen = obtenerCuentaBancariaPorDni(dniOrigen);
        CuentaBancaria cuentaDestino = obtenerCuentaBancariaPorDni(dniDestino);
        if(cuentaOrigen != null && cuentaDestino != null){
            cuentaOrigen.transferir(cuentaDestino, monto);
            cuentaBancariaRepository.save(cuentaOrigen);
            cuentaBancariaRepository.save(cuentaDestino);
        }
    }

    public double mostrarSaldo(double dni){
        CuentaBancaria cuentaBancaria = obtenerCuentaBancariaPorDni(dni);
        if(cuentaBancaria != null){
            return cuentaBancaria.mostrarSaldo();
        }
        return 0;
    }





}
