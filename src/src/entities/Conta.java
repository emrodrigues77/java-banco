package entities;

import contracts.IConta;

import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected ArrayList<String> historico = new ArrayList<>();

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.saldo = 0;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public void imprimirExtrato() {
        System.out.printf("Titular: %s%n", this.cliente.getNome());
        System.out.printf("Agencia: %d%n", this.agencia);
        System.out.printf("Conta: %d%n", this.numero);
        System.out.println("Histórico:");
        this.historico.forEach(System.out::println);
        System.out.printf("Saldo: %.2f%n", this.saldo);
    }

    @Override
    public void sacar(double valor) {
        if (this.saldoSuficiente(valor)) {
            this.saldo -= valor;
            this.historico.add(String.format("%s - Saque - R$ %.2f", LocalDateTime.now(), valor));
        }
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        this.historico.add(String.format("%s - Depósito - R$ %.2f", LocalDateTime.now(), valor));
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        if (this.saldoSuficiente(valor)) {
            this.sacar(valor);
            contaDestino.depositar(valor);
        }
    }

    private boolean saldoSuficiente(double valor) {
        if (this.saldo < valor) {
            System.out.printf("Saldo insuficiente: %.2f%n", this.saldo);
            return false;
        }
        return true;
    }
}
