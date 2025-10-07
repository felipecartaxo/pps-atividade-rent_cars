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

    //Calcula o valor da locacao
    private double valorDeUmaLocacao(Locacao locacao) {
        double valorDaLocacao = 0.0;
        switch(locacao.getCarro().getCodigoDoPreco()) {
            case Automovel.BASICO:
                valorDaLocacao = locacao.getDiasAlugados() * 90.00;
                break;
            case Automovel.FAMILIA:
                valorDaLocacao = locacao.getDiasAlugados() * 130.00;
                break;
            case Automovel.LUXO:
                valorDaLocacao = locacao.getDiasAlugados() * 200.00;
                if(locacao.getDiasAlugados() > 4) {
                    valorDaLocacao *= 0.9;
                }
                break;
        }

        return valorDaLocacao;
    }

    //Calcula os pontos do alugador
    private int valorPontosAlugador(Locacao locacao) {
        int pontos = 1; // Ponto base por locação
        if(locacao.getCarro().getCodigoDoPreco() == Automovel.LUXO && locacao.getDiasAlugados() > 2) {
            pontos += 2;
        }
        return pontos;
    }

    //Agora o extrato fica responsável apenas para exibir os dados
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
            Locacao locacaoAtual = locacoes.next();
            double valorCorrente = valorDeUmaLocacao(locacaoAtual);
            pontosDeAlugadorFrequente += valorPontosAlugador(locacaoAtual);
            
            sequencia++;
            resultado += String.format("%02d. %-20s         %4d           R$ %8.2f" + fimDeLinha, sequencia, locacaoAtual.getCarro().getDescricao(), locacaoAtual.getCarro().getAno(), valorCorrente);

            valorTotal += valorCorrente;
        }

        resultado += "============================================================" + fimDeLinha;
        resultado += String.format("Valor acumulado em diárias....................: R$ %8.2f" + fimDeLinha, valorTotal);
        resultado += "Você acumulou " + pontosDeAlugadorFrequente + " pontos de locador frequente";

        return resultado;
    }
}