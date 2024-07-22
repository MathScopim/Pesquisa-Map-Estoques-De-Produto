import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutosMap {
    private Map<Long, ProdutoMap> estoqueProdutosMap;
    public EstoqueProdutosMap() {
        this.estoqueProdutosMap = new HashMap<>();
    }

    public void adicionarProduto(long cod, String nome, int quantidade, double preco) {
        estoqueProdutosMap.put(cod, new ProdutoMap(nome, preco, quantidade));

    }
    public void exibirProdutos() {
        System.out.println(estoqueProdutosMap);
    }
    public double calculaValorTotalEstoque() {
        double valorTotalEstoque = 0d;
        if(!estoqueProdutosMap.isEmpty()) {
            for(ProdutoMap p : estoqueProdutosMap.values()) {
                valorTotalEstoque += p.getQuantidade() * p.getPreco();
            }
        }
        return valorTotalEstoque;
    }

    public ProdutoMap obterProdutoMaisCaro() {
        ProdutoMap produtoMaisCaro = null;
        double maiorPreco = Double.MIN_VALUE;
        if (!estoqueProdutosMap.isEmpty()) {
            for (ProdutoMap p : estoqueProdutosMap.values()) {
                if(p.getPreco() > maiorPreco) {
                    produtoMaisCaro = p;
                }
            }
        }
        return produtoMaisCaro;
    }

    public static void main(String[] args) {
        EstoqueProdutosMap estoque = new EstoqueProdutosMap();
        estoque.exibirProdutos();
        estoque.adicionarProduto(3L, "Monitor", 10, 3700.87);
        estoque.adicionarProduto(7L, "Cadeira", 4, 230.33);
        estoque.adicionarProduto(1L, "Mesa", 12, 783.12);

        estoque.exibirProdutos();;

        System.out.println("Valor total do estoque: R$" + estoque.calculaValorTotalEstoque());
        System.out.println("Produto mais barato: " + estoque.obterProdutoMaisCaro());

    }
}
