package com.example.bank.repository;

import com.example.bank.entity.CuentaAhorro;
import com.example.bank.entity.CuentaBancaria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CuentaBancariaRepository extends JpaRepository<CuentaBancaria, Long> {
    Optional<CuentaBancaria> findByDni(double dni);
    Optional<CuentaBancaria> deleteByDni(double dni);
    List<CuentaAhorro> findAllByTipo(String tipo);
}
