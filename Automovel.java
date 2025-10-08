public class Automovel {

    public static final int BASICO = 0;
    public static final int FAMILIA = 1;
    public static final int LUXO = 2;

    private String descricao;
    private String placa;
    private int ano; //Ano de fabricação do automóvel
    private int codigoDoPreco;
    
    public Automovel(String descricao, int ano, String placa, int codigoDoPreco) {
        this.descricao = descricao;
        this.placa = placa;
        this.ano = ano;
        this.codigoDoPreco = codigoDoPreco;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getPlaca() {
        return placa;
    }

    public int getAno() {
        return ano;
    }

    public int getCodigoDoPreco() {
        return codigoDoPreco;
    }
    
    public void setCodigoPreco(int codigoDoPreco) {
        this.codigoDoPreco = codigoDoPreco;
    }

    // Ajustamos o método para receber os dias alugados como parâmetro
    public double getValorDeUmaLocacao(int diasAlugados) {
        double valorDaLocacao = 0.0;
        switch(this.getCodigoDoPreco()) {
            case Automovel.BASICO:
                valorDaLocacao = diasAlugados * 90.00;
                break;
            case Automovel.FAMILIA:
                valorDaLocacao = diasAlugados * 130.00;
                break;
            case Automovel.LUXO:
                valorDaLocacao = diasAlugados * 200.00;
                if(diasAlugados > 4) {
                    valorDaLocacao *= 0.9;
                }
                break;
        }

        return valorDaLocacao;
    }

    public int getPontosDeAlugadorFrequente(int diasAlugados) {
        int pontos = 1; // Ponto base por locação
        if(this.codigoDoPreco == Automovel.LUXO && diasAlugados > 2) {
            pontos += 2;
        }
        return pontos;
    }
}
