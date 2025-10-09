public class Automovel implements Alugavel {

    private String descricao;
    private String placa;
    private int ano; //Ano de fabricação do automóvel
    //private int codigoDoPreco;

    private Classificacao classificacao;
    
    public Automovel(String descricao, int ano, String placa, int codigoDeClassificao) {
        this.descricao = descricao;
        this.placa = placa;
        this.ano = ano;

        setCodigoDeClassificacao(codigoDeClassificao);
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
        //Ajuste para que delegar a responsabilidade para o objeto concreto de Classificação
        return classificacao.getCodigoPreco();
    }
    
    public void setCodigoDeClassificacao(int codigoDoPreco) {
        switch(codigoDoPreco) {
            case 0:
                this.classificacao = new Basico();
                break;
            case 1:
                this.classificacao = new Familia();
                break;
            case 2:
                this.classificacao = new Luxo();
                break;
            default:
                throw new IllegalArgumentException("Código de preço inválido.");
        }
    }

    // Ajustamos o método para receber os dias alugados como parâmetro
    public double getValorDeUmaLocacao(int diasAlugados) {
        return classificacao.getValorDeUmaLocacao(diasAlugados);
    }

    public int getPontosDeAlugadorFrequente(int diasAlugados) {
        return classificacao.getPontosDeAlugadorFrequente(diasAlugados);
    }
}
