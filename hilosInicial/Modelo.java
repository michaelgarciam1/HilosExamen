package hilosInicial;

public class Modelo {
    public static void main(String[] args) {
        new Modelo().inicio();
    }

    private void inicio() {
        parte1();
        parte2();
    }


    /*
     * En esta parte se crea un contador y se crean 10 hilos productores y 10 hilos consumidores
     * cada hilo productor incrementa el contador 100 veces y cada hilo consumidor decrementa el contador 100 veces
     * al final se imprime el valor del contador
     * 
     */
    private void parte1() {
        Contador contador = new Contador();

        Thread[] productores = new Thread[10];
        Thread[] consumidores = new Thread[10];

        for (int i = 0; i < productores.length; i++) {
            productores[i] = new Thread(new Producer(contador)); 
            productores[i].start();
        }
        for (int i = 0; i < consumidores.length; i++) {
            consumidores[i] = new Thread(new Consumer(contador)); 
            consumidores[i].start();
        }
        System.out.println("El valor final del contador es: " + contador.getContador());
    }


    /* En esta parte es igual que el anterior , solo que se espera a que todos los hilos terminen
        con el metodo join()
     */
    private void parte2() {
        Contador contador = new Contador();

        Thread[] productores = new Thread[10];
        Thread[] consumidores = new Thread[10];

        for (int i = 0; i < productores.length; i++) {
            productores[i] = new Thread(new Producer(contador)); 
            productores[i].start();
        }
        for (int i = 0; i < consumidores.length; i++) {
            consumidores[i] = new Thread(new Consumer(contador)); 
            consumidores[i].start();
        }

        for (int i = 0; i < productores.length; i++) {
            try {
                productores[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < consumidores.length; i++) {
            try {
                consumidores[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("El valor final del contador es: " + contador.getContador());
    }
}
