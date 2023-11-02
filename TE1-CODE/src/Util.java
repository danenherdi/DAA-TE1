import java.util.Random;

public class Util {
    // Membuat array yang terurut
    static int[] createSortedData(int size) {
        int[] sortedArray = new int[size];
        for (int i = 0; i < size; i++) {
            sortedArray[i] = i + 1;
        }
        return sortedArray;
    }

    // Membuat array dengan urutan acak
    static int[] createRandomData(int size) {
        int[] randomArray = new int[size];
        for (int i = 0; i < size; i++) {
            randomArray[i] = i + 1;
        }
        shuffleArray(randomArray);
        return randomArray;
    }

    // Membuat array yang terbalik
    static int[] createReversedList(int size) {
        int[] reversedArray = new int[size];
        for (int i = 0; i < size; i++) {
            reversedArray[i] = size - i;
        }
        return reversedArray;
    }

    // Mengacak elemen array
    private static void shuffleArray(int[] array) {
        Random rand = new Random(System.currentTimeMillis());
        for (int i = array.length - 1; i > 0; i--) {
            int index = rand.nextInt(i + 1);
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    // Konversi array menjadi string dengan batasan jumlah elemen yang ditampilkan
    static String arrayToString(int[] array, int limit) {
        StringBuilder result = new StringBuilder("[");
        int count = Math.min(array.length, limit);
        for (int i = 0; i < count; i++) {
            result.append(array[i]);
            if (i < count - 1) {
                result.append(", ");
            }
        }
        if (array.length > limit) {
            result.append(", ...");
        }
        result.append("]");
        return result.toString();
    }


}
