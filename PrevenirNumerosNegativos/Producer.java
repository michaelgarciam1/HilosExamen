package PrevenirNumerosNegativos;

public class Producer implements Runnable {

    private Contador contador;

    public Producer(Contador contador) {
        this.contador = contador;
    }

    public void producir() {
        synchronized (contador) {
            for (int i = 0; i < 100; i++) {
                this.contador.incrementar();
            }
            contador.notifyAll();
        }
    }

    @Override
    public void run() {
        producir();
    }

}