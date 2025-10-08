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

    //Calcula o valor total das locações
    public double getValorTotal() {
        double valorTotal = 0.0;
        Iterator<Locacao> locacoes = carrosAlugados.iterator();
        while(locacoes.hasNext()) {
            Locacao locacaoAtual = locacoes.next();
            valorTotal += locacaoAtual.getValorDeUmaLocacao(locacaoAtual);
        }
        return valorTotal;
    }

    //Calcula os pontos totais do alugador frequente
    public int getPontosTotaisDeAlugadorFrquente() {
        int pontosDeAlugadorFrequente = 0;
        Iterator<Locacao> locacoes = carrosAlugados.iterator();
        while(locacoes.hasNext()) {
            Locacao locacaoAtual = locacoes.next();
            pontosDeAlugadorFrequente += locacaoAtual.getPontosDeAlugadorFrequente(locacaoAtual);
        }
        return pontosDeAlugadorFrequente;
    }

    //Agora o extrato fica responsável apenas para exibir os dados
    public String extrato() {
        final String fimDeLinha = System.getProperty("line.separator");
//        double valorTotal = 0.0;
//        int pontosDeAlugadorFrequente = 0;
        int sequencia = 0;

        Iterator<Locacao> locacoes = carrosAlugados.iterator();

        String resultado = "Registro de Alugueis de " + getNome() + fimDeLinha;
        resultado += String.format("Seq Automovel                    Ano da Locacao Valor Pago" + fimDeLinha);
        resultado += String.format("=== ============================ ============== ============\n");

        while(locacoes.hasNext()) {
            Locacao locacaoAtual = locacoes.next();
//            pontosDeAlugadorFrequente += locacaoAtual.getPontosDeAlugadorFrequente(locacaoAtual);

            sequencia++;
            resultado += String.format("%02d. %-20s         %4d           R$ %8.2f" + fimDeLinha, sequencia, locacaoAtual.getCarro().getDescricao(), locacaoAtual.getCarro().getAno(), locacaoAtual.getValorDeUmaLocacao(locacaoAtual));
        }

        resultado += "============================================================" + fimDeLinha;
        resultado += String.format("Valor acumulado em diárias....................: R$ %8.2f" + fimDeLinha, getValorTotal());
        resultado += "Você acumulou " + getPontosTotaisDeAlugadorFrquente() + " pontos de locador frequente";

        return resultado;
    }
}