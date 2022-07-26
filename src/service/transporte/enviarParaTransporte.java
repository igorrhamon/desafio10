package service.transporte;

import model.Compra;

public class EnviarParaTransporte  implements Runnable {
    private Compra compra;

    public EnviarParaTransporte(Compra compra) {
        this.compra = compra;
    }

    @Override
    public void run() {
        synchronized(this) {
            System.out.println("Compra enviada para o transporte");
            notify();
        }
                
    }


}
