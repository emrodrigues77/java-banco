import contracts.IConta;
import entities.Banco;
import entities.Cliente;
import entities.ContaCorrente;
import entities.ContaPoupanca;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Banco banco = new Banco("Banco do Brasil");
        Cliente cliente = new Cliente("João");
        IConta contaCorrente = new ContaCorrente(cliente);
        IConta contaPoupanca = new ContaPoupanca(cliente);

        banco.adicionarConta(contaCorrente);
        banco.adicionarConta(contaPoupanca);

        contaCorrente.depositar(1000);
        contaPoupanca.depositar(1000);

        contaCorrente.sacar(500);
        contaPoupanca.sacar(500);

        contaCorrente.transferir(500, contaPoupanca);

        banco.listarContas();
    }
}