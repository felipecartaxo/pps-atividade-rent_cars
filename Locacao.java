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
}
