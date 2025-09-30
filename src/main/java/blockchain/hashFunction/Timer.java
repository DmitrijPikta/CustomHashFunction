package blockchain.hashFunction;

public class Timer {
    public long measure(Runnable task){
        long startTime = System.nanoTime();
        task.run();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}
