import java.util.Random;

public class Util {
    // Method untuk membuat array data terurut
    static int[] createSortedData(int size) {
        int[] sortedArray = new int[size];
        for (int i = 0; i < size; i++) {
            sortedArray[i] = i + 1;
        }
        return sortedArray;
    }

    // Method untuk membuat array data acak
    static int[] createRandomData(int size) {
        int[] randomArray = new int[size];
        for (int i = 0; i < size; i++) {
            randomArray[i] = i + 1;
        }
        shuffleArray(randomArray);
        return randomArray;
    }

    // Method untuk membuat array data reversed
    static int[] createReversedList(int size) {
        int[] reversedArray = new int[size];
        for (int i = 0; i < size; i++) {
            reversedArray[i] = size - i;
        }
        return reversedArray;
    }

    // Method untuk mengacak elemen secara manual
    private static void shuffleArray(int[] array) {
        Random rand = new Random(System.currentTimeMillis());
        for (int i = array.length - 1; i > 0; i--) {
            int index = rand.nextInt(i + 1);
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
}
