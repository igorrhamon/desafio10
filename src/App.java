import java.util.HashMap;
import java.util.Map;

import model.Compra;
import model.Estoque;
import model.Pagamento;
import model.Produto;
import service.estoque.BloqueiaEstoqueService;
import service.estoque.VerificaEstoqueService;
import service.pagamento.EfetuaPagamentoService;

public class App {
    public static void main(String[] args) throws Exception {
        Produto produto1 = new Produto("Produto 1", 10.0);
        Produto produto2 = new Produto("Produto 2", 20.0);
        Estoque estoque = new Estoque();
        Map<Produto, Integer> produtos = new HashMap<>();
        produtos.put(produto1, 1);
        produtos.put(produto2, 2);
        Compra compra = new Compra(produtos);
        Pagamento pagamento = new Pagamento(compra);
        VerificaEstoqueService verificaEstoque = new VerificaEstoqueService(compra, estoque);

        verificaEstoque.executa();

        EfetuaPagamentoService efetuaPagamento = new EfetuaPagamentoService(pagamento);
        BloqueiaEstoqueService bloqueiaEstoque = new BloqueiaEstoqueService(compra, estoque, new Thread(efetuaPagamento));
        bloqueiaEstoque.executa(estoque);

        System.out.println("Estoque: " + estoque.getItens());
    }
}
