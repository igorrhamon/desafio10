package service.estoque;

import model.Compra;
import model.Estoque;
import model.Pagamento;
import service.pagamento.EfetuaPagamentoService;

public class BloqueiaEstoqueService implements Runnable {

    
    private Thread pagamentoThread;
    private Estoque estoque;
    private Compra compra;
    
    
    
    public BloqueiaEstoqueService(Compra compra, Estoque estoque, Thread pagamentoThread) {
        this.compra = compra;
        this.estoque = estoque;
        this.pagamentoThread = pagamentoThread;
    }
    @Override
    public void run() {
        // Verifica se o produto está disponível no estoque
        this.pagamentoThread.start();
        synchronized(this.pagamentoThread){
            try {
                this.pagamentoThread.wait();
                System.out.println("Estoque Bloqueado");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    
    }
    public void executa(Estoque estoque) {
        this.estoque = estoque;
        Thread thread = new Thread(this);
        thread.start();
    }
}
