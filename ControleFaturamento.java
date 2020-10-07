
class Conta {
	String cpf;
	String agencia;
	String conta;
	String digito;
	double saldo;
	
	public Conta(String cpf, String agencia, String conta, String digito, double saldo) {
		this.cpf = cpf;
		this.agencia = agencia;
		this.conta = conta;
		this.digito = digito;
		this.saldo = saldo;
	}
	
	protected boolean saida_valida(double valor) {
		if (this.saldo - valor < 0) {
			return false;
		}
		
		return true;
	}
	
	public void saque(double valor) {
		if (saida_valida(valor)) {
			this.saldo -= valor;
		}
		else {
			System.out.println("Saldo insuficiente!");
		}
	}
	
	public void deposito(double valor) {
		this.saldo += valor;
	}
	
	public void transferencia (Conta conta_destino, double valor) {
		if (saida_valida(valor)) {
			this.saldo -= valor;
			conta_destino.deposito(valor);
		}
		else {
			System.out.println("Saldo insuficiente!");
		}
	}
	
	public double consulta_saldo(){
		return this.saldo;
	}
}

class ContaInvestimento extends Conta{

	public ContaInvestimento(String cpf, String agencia, String conta, String digito, double saldo) {
		super(cpf, agencia, conta, digito, saldo);
	}

	@Override
	public void deposito(double valor) {
		this.saldo += valor*1.01;
	}
	
	@Override
	protected boolean saida_valida(double valor) {
		if (valor > this.saldo*2) {
			return false;
		}
		
		return true;
	}
}

class ContaCorrente extends Conta{
	public ContaCorrente(String cpf, String agencia, String conta, String digito, double saldo) {
		super(cpf, agencia, conta, digito, saldo);
	}
}

public class Ex_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ContaInvestimento conta1 = new ContaInvestimento("111.111.222-55", "1234", "7676",
				"3", 10000.00);
		ContaCorrente conta2 = new ContaCorrente("222.222.222-33", "1234", "4444",
				"1", 5000.00);
		
		//Teste regra de limite especial de saque para conta investimento
		conta1.saque(15000);
		
		System.out.println(conta1.consulta_saldo());

		conta1.saque(1000);
		System.out.println(conta1.consulta_saldo());

		
		//Teste depósito com bônus conta investimento
		conta1.deposito(5000);
		System.out.println(conta1.consulta_saldo());
		
		//Teste depósito conta corrente
		conta2.deposito(5000);
		System.out.println(conta1.consulta_saldo());

		//Teste transferência -> Lembrando que a conta investimento recebe bonus
		conta2.transferencia(conta1, 1000.00);
		System.out.println(conta1.consulta_saldo());
		System.out.println(conta2.consulta_saldo());
		
		conta1.transferencia(conta2, 100.00);
		System.out.println(conta1.consulta_saldo());
		System.out.println(conta2.consulta_saldo());
	}

}