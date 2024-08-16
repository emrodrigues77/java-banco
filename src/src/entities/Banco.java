package entities;

import contracts.IConta;

import java.util.ArrayList;

public class Banco {

    private String nome;
    private ArrayList<IConta> contas = new ArrayList<>();

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    public void adicionarConta(IConta conta) {
        this.contas.add(conta);
    }

    public void removerConta(IConta conta) {
        this.contas.remove(conta);
    }

    public void listarContas() {
        for (IConta conta : this.contas) {
            conta.imprimirExtrato();
        }
    }
}
