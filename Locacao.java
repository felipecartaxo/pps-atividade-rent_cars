public class Locacao {

    private Automovel carro;
    private int diasAlugados;
    
    public Locacao(Automovel carro, int diasAlugados) {
        this.carro = carro;
        this.diasAlugados = diasAlugados;
    }

    public Automovel getCarro() {
        return carro;
    }

    public int getDiasAlugados() {
        return diasAlugados;
    }

    //Calcula o valor da locacao
    public double getValorDeUmaLocacao(Locacao locacao) {
        double valorDaLocacao = 0.0;
        switch(locacao.getCarro().getCodigoDoPreco()) {
            case Automovel.BASICO:
                valorDaLocacao = locacao.getDiasAlugados() * 90.00;
                break;
            case Automovel.FAMILIA:
                valorDaLocacao = locacao.getDiasAlugados() * 130.00;
                break;
            case Automovel.LUXO:
                valorDaLocacao = locacao.getDiasAlugados() * 200.00;
                if(locacao.getDiasAlugados() > 4) {
                    valorDaLocacao *= 0.9;
                }
                break;
        }

        return valorDaLocacao;
    }

    //Calcula os pontos do alugador
    public int getPontosDeAlugadorFrequente(Locacao locacao) {
        int pontos = 1; // Ponto base por locação
        if(locacao.getCarro().getCodigoDoPreco() == Automovel.LUXO && locacao.getDiasAlugados() > 2) {
            pontos += 2;
        }
        return pontos;
    }

    //Calcula o valor total de uma locacao

}
