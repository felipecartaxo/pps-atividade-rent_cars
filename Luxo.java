public class Luxo extends Classificacao {

    @Override
    int getCodigoPreco() {
        return 2;
    }

    @Override
    double getValorDeUmaLocacao(int diasAlugados) {
        double valorLocacao = diasAlugados * 200.00;

        if(diasAlugados > 4) {
            valorLocacao *= 0.9;
        }

        return valorLocacao;
    }

    @Override
    int getPontosDeAlugadorFrequente(int diasAlugados) {
        int pontosAlugador = 1;

        if(diasAlugados > 2) {
            pontosAlugador += 2;
        }



        return pontosAlugador;
    }
}
