public class Familia extends Classificacao {

    @Override
    int getCodigoPreco() {
        return 1;
    }

    @Override
    double getValorDeUmaLocacao(int diasAlugados) {
        return diasAlugados * 130.00;
    }
}
