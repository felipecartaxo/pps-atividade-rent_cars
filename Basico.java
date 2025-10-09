public class Basico extends Classificacao {

    @Override
    int getCodigoPreco() {
        return 0;
    }

    @Override
    double getValorDeUmaLocacao(int diasAlugados) {
        return diasAlugados * 90.00;
    }
}
