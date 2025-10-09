public interface Alugavel {

    public String getDescricao();
    public int getAno();
    public double getValorDeUmaLocacao(int diasAlugados);
    public int getPontosDeAlugadorFrequente(int diasAlugados);
}
