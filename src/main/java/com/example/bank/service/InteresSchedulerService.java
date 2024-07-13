package com.example.bank.service;


import com.example.bank.entity.CuentaAhorro;
import com.example.bank.entity.CuentaBancaria;
import com.example.bank.repository.CuentaBancariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InteresSchedulerService {

    @Autowired
    private CuentaBancariaRepository cuentaBancariaRepository;

    @Scheduled(cron = "0 0 0 * * ?")  // Ejecuta todos los días a medianoche
    public void aplicarInteresesDiarios() {
        List<CuentaAhorro> cuentas = cuentaBancariaRepository.findAllByTipo("Ahorro");
        for (CuentaAhorro cuenta : cuentas) {
            double nuevoSaldo = cuenta.getSaldo() + (cuenta.getSaldo() * 0.05);
            cuenta.setSaldo(nuevoSaldo);
            cuentaBancariaRepository.save(cuenta);
            System.out.println("Se actualizó el saldo con los intereses para la cuenta: " + cuenta.getDni());
        }
    }
}
