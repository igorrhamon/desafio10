import model.Estoque;
import model.Pagamento;
import service.estoque.BloqueiaEstoque;

public class App {
    public static void main(String[] args) throws Exception {
        Estoque estoque = new Estoque();
        Pagamento pagamento = new Pagamento();

        BloqueiaEstoque bloqueiaEstoque = new BloqueiaEstoque(pagamento, estoque);
        Thread thread = new Thread(bloqueiaEstoque);
        thread.start();

        Thread.sleep(5000);

        System.out.println("Estoque bloqueado: " + estoque.isEstoqueBloqueado());

    }
}
