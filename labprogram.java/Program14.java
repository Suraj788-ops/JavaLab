class SharedData {

    private int value;
    private boolean available = false;

    synchronized void produce(int value) {

        while (available) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        this.value = value;
        available = true;

        System.out.println("Produced: " + value);

        notify();
    }

    synchronized void consume() {

        while (!available) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        System.out.println("Consumed: " + value);

        available = false;

        notify();
    }
}

class Producer extends Thread {

    private SharedData data;

    Producer(SharedData data) {
        this.data = data;
    }

    public void run() {

        for (int i = 1; i <= 10; i++) {

            data.produce(i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class Consumer extends Thread {

    private SharedData data;

    Consumer(SharedData data) {
        this.data = data;
    }

    public void run() {

        for (int i = 1; i <= 10; i++) {

            data.consume();

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class Program14 {

    public static void main(String[] args) {

        SharedData data = new SharedData();

        Producer producer = new Producer(data);
        Consumer consumer = new Consumer(data);

        producer.start();
        consumer.start();
    }
}