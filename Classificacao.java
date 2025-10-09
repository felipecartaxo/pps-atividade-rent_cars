public abstract class Classificacao {

    abstract int getCodigoPreco();
    abstract double getValorDeUmaLocacao(int diasAlugados);

    //Como das 3 classificações, 2 delas retornam apenas 1 ponto, faz mais sentido já criar fazer a implementação e deixar apenas para LUXO sobreescrever
    int getPontosDeAlugadorFrequente(int diasAlugados) {
        return 1;
    };
}
