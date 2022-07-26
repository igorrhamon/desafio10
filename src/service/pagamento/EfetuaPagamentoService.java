package service.pagamento;

import model.Pagamento;

public class EfetuaPagamentoService implements Runnable{

    private Pagamento pagamento;
    

    public EfetuaPagamentoService(Pagamento pagamento) {
        this.pagamento = pagamento;
    }


    @Override
    public void run() {
        synchronized(this){
            try {
                System.out.println("Verificando pagamento...");
                Thread.sleep(2000);
                this.pagamento.setPagamentoRealizado(true);
                System.out.println("Pagamento realizado");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            notify();
        }

    }
    
}
