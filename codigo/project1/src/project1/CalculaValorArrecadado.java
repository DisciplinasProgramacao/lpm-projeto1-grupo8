package project1;

	/**
	
	 */
public class CalculaValorArrecadado {
    /**
    *   Esse método é utilizado para calcular o valor total arrecadado de determinado produto.
        @param valorVenda
        @param quantidadeVendida
	 */
    public static double calculaValorArrecadado(double valorVenda, int quantidadeVendida){

        double valorTotal = 0;

        valorTotal = valorVenda * quantidadeVendida;

        return valorTotal;
    }
}
