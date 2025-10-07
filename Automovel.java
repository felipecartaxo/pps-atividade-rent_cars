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
}
