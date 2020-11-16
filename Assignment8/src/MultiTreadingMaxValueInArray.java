import java.util.Random;

class ThreadMax implements Runnable {
    private int max = Integer.MIN_VALUE;
    int[] array;
    int low;
    int high;
    public ThreadMax(int[] array, int low, int high) {
        this.array = array;
        this.low = low;
        this.high = high;
    }

    public int getMax() {
        return this.max;
    }

    @Override
    public void run() {
        for (int i = low; i < high; i++) {
            this.max = Math.max(this.max, array[i]);
        }
    }
}

public class MultiTreadingMaxValueInArray {

    public static void generateArray(int[] arr) {
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(9999999);
        }
    }

    public static int max(int[] arr) {
        int max = Integer.MIN_VALUE;
        int threadNumber = 4;
        ThreadMax[] threadMax = new ThreadMax[threadNumber];
        int length = arr.length / threadNumber;
        for (int i = 0; i < threadMax.length; i++) {
            threadMax[i] = new ThreadMax(arr, length * i, length * (i + 1));
            threadMax[i].run();
        }

        for (ThreadMax thread : threadMax) {
            max = Math.max(max, thread.getMax());
        }
        return max;
    }

    public static int regularMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            max = Math.max(max, i);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[4000000];
        generateArray(arr);
        int max = max(arr);
        System.out.println("Max: " + max);
        max = regularMax(arr);
        System.out.println("regularSum: " + max);
    }
}

