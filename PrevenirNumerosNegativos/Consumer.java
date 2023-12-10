package PrevenirNumerosNegativos;

public class Consumer implements Runnable {

    private Contador contador;

    public Consumer(Contador contador) {
        this.contador = contador;
    }

    public void consumir() {
        for (int i = 0; i < 100; i++) {
            synchronized (contador) {
                while (contador.getContador() <= 0) {
                    try {
                        System.out.println("El contador es 0, esperando a que se incremente");
                        contador.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                this.contador.decrementar();
            }
        }
    }

    @Override
    public void run() {
        consumir();
    }

}
