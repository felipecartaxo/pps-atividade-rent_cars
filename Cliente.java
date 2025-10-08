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
            valorTotal += locacaoAtual.getValorDeUmaLocacao();
        }
        return valorTotal;
    }

    //Calcula os pontos totais do alugador frequente
    public int getPontosTotaisDeAlugadorFrequente() {
        int pontosDeAlugadorFrequente = 0;
        Iterator<Locacao> locacoes = carrosAlugados.iterator();
        while(locacoes.hasNext()) {
            Locacao locacaoAtual = locacoes.next();
            pontosDeAlugadorFrequente += locacaoAtual.getPontosDeAlugadorFrequente();
        }
        return pontosDeAlugadorFrequente;
    }

    //Agora o extrato fica responsável apenas para exibir os dados
    public String extrato() {
        final String fimDeLinha = System.getProperty("line.separator");
        int sequencia = 0;

        Iterator<Locacao> locacoes = carrosAlugados.iterator();

        String resultado = "Registro de Alugueis de " + getNome() + fimDeLinha;
        resultado += String.format("Seq Automovel                    Ano da Locacao Valor Pago" + fimDeLinha);
        resultado += String.format("=== ============================ ============== ============\n");

        while(locacoes.hasNext()) {
            Locacao locacaoAtual = locacoes.next();

            sequencia++;
            resultado += String.format("%02d. %-20s         %4d           R$ %8.2f" + fimDeLinha, sequencia, locacaoAtual.getCarro().getDescricao(), locacaoAtual.getCarro().getAno(), locacaoAtual.getValorDeUmaLocacao());
        }

        resultado += "============================================================" + fimDeLinha;
        resultado += String.format("Valor acumulado em diárias....................: R$ %8.2f" + fimDeLinha, getValorTotal());
        resultado += "Você acumulou " + getPontosTotaisDeAlugadorFrequente() + " pontos de locador frequente";

        return resultado;
    }

    public String extratoHTML() {
        final String fimDeLinha = System.getProperty("line.separator");
        int sequencia = 0;

        Iterator<Locacao> locacoes = carrosAlugados.iterator();
        String resultado = "<html><body>" + fimDeLinha;
        resultado = String.format("<h2>Registro de Locacoes de <EM> %s<EM></h2>", getNome()) + fimDeLinha;

        resultado += "<table border=\"1\"><tr><th>Seq</th><th>Automóvel</th><th>Ano</th><th>Diárias</th><th>Valor</th></tr>" + fimDeLinha;

        while(locacoes.hasNext()) {
            Locacao locacaoAtual = locacoes.next();
            sequencia++;
            resultado += String.format("<tr><th>%02d.</th><th>%s</th><th>%4d</th><th>%2d</th><th>R$ %8.2f</th></tr>" + fimDeLinha, sequencia, locacaoAtual.getCarro().getDescricao(),locacaoAtual.getCarro().getAno(), locacaoAtual.getDiasAlugados(), locacaoAtual.getValorDeUmaLocacao());
        } //Fim do while

        //Adiciona rodapé
        resultado += String.format("<tfoot><tr><td colspan=\"4\">Valor Acumulado em diárias:</td><td><EM>R$ %8.2f</EM></td></tr></tfoot></table>" + fimDeLinha, getValorTotal());

        resultado += "<P>Voce acumulou <EM>" + getPontosTotaisDeAlugadorFrequente() + " pontos </EM> de alugador frequente</p></body></html> ";

        return resultado;
    } //Fim de extratoHTML
}