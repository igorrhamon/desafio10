package service.transporte;

import model.Compra;

public class enviarParaTransporte  implements Runnable {
    private Compra compra;

    public enviarParaTransporte(Compra compra) {
        this.compra = compra;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        
    }


}
