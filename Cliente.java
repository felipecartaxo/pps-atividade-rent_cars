import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cliente {

    private String nome;
    private List<Locacao> carrosAlugados = new ArrayList<Locacao>();
    
    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void adicionaLocacao(Locacao locacao) {
        carrosAlugados.add(locacao);
    }

    public String extrato() {
        final String fimDeLinha = System.getProperty("line.separator");
        double valorTotal = 0.0;
        int pontosDeAlugadorFrequente = 0;
        int sequencia = 0;

        Iterator<Locacao> locacoes = carrosAlugados.iterator();
        String resultado = "Registro de Alugueis de " + getNome() + fimDeLinha;
        resultado += String.format("Seq Automovel                    Ano da Locacao Valor Pago" + fimDeLinha);
        resultado += String.format("=== ============================ ============== ============\n");

        while(locacoes.hasNext()) {
            double valorCorrente = 0.0;
            Locacao cada = locacoes.next();

            //Determina valores para cada linha de automóveis
            switch(cada.getCarro().getCodigoDoPreco()) {
                case Automovel.BASICO: // R$ 90.00 por dia
                    valorCorrente += cada.getDiasAlugados() * 90.00;
                    break;

                case Automovel.FAMILIA: // R$ 130.00 por dia
                    valorCorrente += cada.getDiasAlugados() * 130.00;
                    break;

                case Automovel.LUXO: // R$ 200.00 por dia
                    valorCorrente += cada.getDiasAlugados() * 200.00;

                    // Acima de 4 diárias tem 10% de desconto
                    if(cada.getDiasAlugados() > 4) {
                        valorCorrente *= 0.9;
                    }
                    
                    break;
            } //Fim do switch

            //Trata de pontos de alugador frequente
            pontosDeAlugadorFrequente++;

            //Adiciona bônus para aluguel de um lançamento por pelo menos 2 dias
            if(cada.getCarro().getCodigoDoPreco() == Automovel.LUXO && cada.getDiasAlugados() > 2) {
                pontosDeAlugadorFrequente+= 2;
            }

            //Mostra valores para este alugel
            sequencia++;
            resultado += String.format("%02d. %-20s         %4d           R$ %8.2f" + fimDeLinha, sequencia, cada.getCarro().getDescricao(), cada.getCarro().getAno(), valorCorrente);

            valorTotal += valorCorrente;
        } //Fim do while

        //Adiciona rodapé
        resultado += "============================================================" + fimDeLinha;
        resultado += String.format("Valor acumulado em diárias....................: R$ %8.2f" + fimDeLinha, valorTotal);
        resultado += "Você acumulou " + pontosDeAlugadorFrequente + " pontos de alugador frequente";

        return resultado;
    }
}
