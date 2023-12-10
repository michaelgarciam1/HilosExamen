package hilosInicial;

public class Modelo {
    public static void main(String[] args) {
        Contador contador = new Contador();
     
        Producer[] productores = new Producer[10];
        Consumer[] consumidores = new Consumer[10];
       
        for(int i = 0; i < productores.length; i++) {
            productores[i] = new Producer(contador);
            consumidores[i] = new Consumer(contador);
            Thread hilo1 = new Thread(productores[i]);
            Thread hilo2 = new Thread(consumidores[i]);
            hilo1.start();
            hilo2.start();
        }
        System.out.println("El valor final del contador es: " + contador.getContador());
    }
}
