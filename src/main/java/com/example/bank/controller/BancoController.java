package com.example.bank.controller;


import com.example.bank.entity.CuentaAhorro;
import com.example.bank.entity.CuentaBancaria;
import com.example.bank.entity.CuentaCorriente;
import com.example.bank.exception.CuentaNoEncontradaException;
import com.example.bank.exception.SaldoInsuficienteException;
import com.example.bank.service.CuentaBancariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/banco")
public class BancoController {

    @Autowired
    private CuentaBancariaService cuentaBancariaService;

    @PostMapping("/crearCuentaCorriente")
    public CuentaBancaria crearCuentaCorriente(@RequestBody CuentaCorriente cuentaCorriente) {
        return cuentaBancariaService.crearCuentaBancaria(cuentaCorriente);
    }

    @PostMapping("/crearCuentaAhorro")
    public CuentaBancaria crearCuentaAhorro(@RequestBody CuentaAhorro cuentaAhorro) {
        return cuentaBancariaService.crearCuentaBancaria(cuentaAhorro);
    }

    @PostMapping("/depositar/{numeroCuenta}")
    public void depositar(@PathVariable double numeroCuenta, @RequestParam double cantidad) throws CuentaNoEncontradaException {
        cuentaBancariaService.depositar(numeroCuenta, cantidad);
    }

    @PostMapping("/retirar/{numeroCuenta}")
    public void retirar(@PathVariable double numeroCuenta, @RequestParam double cantidad) throws CuentaNoEncontradaException, SaldoInsuficienteException {
        cuentaBancariaService.retirar(numeroCuenta, cantidad);
    }

    @GetMapping("/consultarSaldo/{numeroCuenta}")
    public double consultarSaldo(@PathVariable double numeroCuenta) throws CuentaNoEncontradaException {
        return cuentaBancariaService.mostrarSaldo(numeroCuenta);
    }

    @PostMapping("/transferir/{numeroCuentaOrigen}/{numeroCuentaDestino}/{cantidad}")
    public void transferir(@PathVariable double numeroCuentaOrigen, @PathVariable double numeroCuentaDestino, @PathVariable double cantidad) throws CuentaNoEncontradaException, SaldoInsuficienteException {
        cuentaBancariaService.transferir(numeroCuentaOrigen, numeroCuentaDestino, cantidad);
    }

}
