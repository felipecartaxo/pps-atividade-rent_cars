public class Locacao {

    //private Automovel carro;
    private Alugavel carro;
    private int diasAlugados;
    
    public Locacao(Alugavel carro, int diasAlugados) {
        this.carro = carro;
        this.diasAlugados = diasAlugados;
    }

    public Alugavel getCarro() {
        return carro;
    }

    public int getDiasAlugados() {
        return diasAlugados;
    }

    //Calcula o valor da locacao
    public double getValorDeUmaLocacao() {
       return carro.getValorDeUmaLocacao(this.diasAlugados);
    }

    //Calcula os pontos do alugador
    public int getPontosDeAlugadorFrequente() {
        return carro.getPontosDeAlugadorFrequente(this.diasAlugados);
    }
}
