package service.pagamento;

import model.Pagamento;

public class EfetuaPagamento implements Runnable{

    private Pagamento pagamento;
    

    public EfetuaPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }


    @Override
    public void run() {
        synchronized(this){
            try {
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
