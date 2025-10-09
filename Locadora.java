public class Locadora {

    public static void main(String[] args) {
        Cliente c1 = new Cliente("Alex Sandro");

        c1.adicionaLocacao(new Locacao(new Automovel("Toyota Corolla xEi", 2021, "PLN0525", 2), 10));
        c1.adicionaLocacao(new Locacao(new Automovel("Fiat Mobi", 2021, "JPA2464", 0), 2));
        c1.adicionaLocacao(new Locacao(new Automovel("BMW Série 7", 2022, "UBA0808", 2), 30));
        c1.adicionaLocacao(new Locacao(new Automovel("Fiat Siena", 2023, "ABC0001", 1), 4));
        c1.adicionaLocacao(new Locacao(new Automovel ("Honda HRV", 2022, "KJD9745", 1), 10));
        c1.adicionaLocacao(new Locacao(new Automovel("Volkswagen Gol", 2021, "JJJ0055", 0), 3));

        System.out.println(c1.extrato());
    }
}
