import java.util.HashMap;
import java.util.Map;

import model.Compra;
import model.Estoque;
import model.NotaFiscal;
import model.Pagamento;
import model.Produto;
import service.estoque.BloqueiaEstoqueService;
import service.estoque.VerificaEstoqueService;
import service.nota_fiscal.EmiteNotaService;
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
        NotaFiscal notaFiscal = new NotaFiscal(compra);

        Thread verificaEstoqueServiceThread = new Thread( new VerificaEstoqueService(compra, estoque));
        Thread pagamentoServiceThread = new Thread( new EfetuaPagamentoService(pagamento));
        Thread emiteNotaServiceThread = new Thread( new EmiteNotaService(compra));
        Thread bloqueiaEstoqueServiceThread = new Thread( new BloqueiaEstoqueService(compra, estoque));
        pagamentoServiceThread.start();
        synchronized(pagamentoServiceThread) {
            pagamentoServiceThread.wait();
            System.out.println("Pagamento efetuado");
            verificaEstoqueServiceThread.start();
            synchronized(verificaEstoqueServiceThread) {
                verificaEstoqueServiceThread.wait();
                System.out.println("Estoque verificado");
                emiteNotaServiceThread.start();
                bloqueiaEstoqueServiceThread.start();
                synchronized(emiteNotaServiceThread) {
                    emiteNotaServiceThread.wait();
                    System.out.println("Nota fiscal emitida");
                    synchronized(bloqueiaEstoqueServiceThread) {
                        bloqueiaEstoqueServiceThread.wait();
                        System.out.println("Estoque bloqueado");
                    }
                    System.out.println('\n' + "Compra efetuada com sucesso");
                }
            }
        }


    }
}
