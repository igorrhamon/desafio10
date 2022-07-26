package service.estoque;

import model.Estoque;
import model.Pagamento;
import service.pagamento.EfetuaPagamentoService;

public class BloqueiaEstoqueService implements Runnable {

    
    private Thread pagamentoThread;
    private Pagamento pagamento;
    private Estoque estoque;

    public BloqueiaEstoqueService(Pagamento pagamento, Estoque estoque) {
        this.pagamento = pagamento;
        this.estoque = estoque;
    }

    @Override
    public void run() {
        // Verifica se o produto está disponível no estoque
        System.out.println("Verificando estoque");
        
        System.out.println("Produto disponível no estoque");
        try {
            Thread.sleep(2000);
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        

        
        // Se estiver disponível, realiza o pagamento
        
        this.pagamentoThread = new Thread( new EfetuaPagamentoService(this.pagamento));
        this.pagamentoThread.start();

        synchronized (this.pagamentoThread) {
            try {
                this.pagamentoThread.wait();
                this.estoque.setEstoqueBloqueado(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException("Pagamento não realizado");
            }
        }
        
    
    }
}
