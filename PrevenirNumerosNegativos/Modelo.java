package PrevenirNumerosNegativos;

public class Modelo {
    public static void main(String[] args) {
        new Modelo().inicio();
    }

    private void inicio() {
        parte1();
    }

    /*
     * Para prevenir que el contador llegue a valores negativos, 
     * en la clase consumer, se pone un while que mientras el contador sea menor o igual a 0
     * y se hace el wait() para que el hilo se quede esperando a que el contador se incremente.
     * En la clase producer, se pone un notifyAll() para que cuando el contador se incremente
     * se notifique a todos los hilos que estan esperando a que el contador se incremente.
     * 
     *  
     */
    private void parte1() {
        Contador contador = new Contador();

        Thread[] productores = new Thread[4];
        Thread[] consumidores = new Thread[10];

        for (int i = 0; i < productores.length; i++) {
            productores[i] = new Thread(new Producer(contador));
            productores[i].start();
        }
        for (int i = 0; i < consumidores.length; i++) {
            consumidores[i] = new Thread(new Consumer(contador));
            consumidores[i].start();
        }
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println("El valor final del contador es: " + contador.getContador());
    }

}
