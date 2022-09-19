public class conta{
	
	public static int qtdContas;
	
	
	private int numConta;
	private String nomeCliente;
	private double saldo;
	
	public conta(String nomeCliente) {
		this.nomeCliente = nomeCliente;
		qtdContas++;
		numConta = qtdContas;
	}
	public void setNomeCorrentista(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	
	}

	public int getNumConta() {
		return numConta;
	}

	public String saque(double valor) {
		if (valor > 0) {
			if (saldo >= valor) {
				saldo -= valor;
				return("Saldo: R$ " + saldo);
			} else {
				return("Saldo insuficiente!");
			}
		} else {
			return("Valor de saque inv�lido!");
		}
	}
	
	public String deposito(double valor) {
		if (valor > 0) {
			saldo += valor;
			return("Saldo: R$ " + saldo);
		} else {
			return("Valor de dep�sito inv�lido!");
		}
	}

	public String getInformacoes() {
		return("" + 
				"Cliente: " + nomeCliente +
				"\nN�mero da Conta: " + numConta + 
				"\nSaldo: R$ " + saldo);
	}
}
