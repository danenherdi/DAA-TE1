import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.util.List;

public class Main {

    // A utility function to print an array
    static void printArray(int arr[]) {
        for (int value : arr) System.out.print(value + " ");
        System.out.println();
    }

    public static void main(String[] args) {
//        // Jumlah elemen dalam setiap list
//        int[] arraySizes = {1000, 10000, 100000};
//
//        for (int size : arraySizes) {
//            int[] sortedArray = Util.createSortedData(size);
//            int[] randomArray = Util.createRandomData(size);
//            int[] reversedArray = Util.createReversedList(size);
//
//            // Menampilkan beberapa elemen pertama array untuk memastikan kodenya berfungsi
//            System.out.println("Sorted Array (Size " + size + "): " + Util.arrayToString(sortedArray, 10));
//            System.out.println("Random Array (Size " + size + "): " + Util.arrayToString(randomArray, 10));
//            System.out.println("Reversed Array (Size " + size + "): " + Util.arrayToString(reversedArray, 10));
//        }

        int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
        int[] randomArr1000 = Util.createRandomData(1000);
        System.out.println("Random Array (Size " + randomArr1000.length + "): " + Util.arrayToString(randomArr1000, 10));

        System.out.println("PEMBATAS ATAS");
        printArray(randomArr1000);

        // Radix sort performance
        long startTime = System.currentTimeMillis();
        Radixsort.radixSort(randomArr1000);
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        System.out.println("Waktu eksekusi Radix Sort: " + resultTime + " ms");

        System.out.println("PEMBATAS BAWAH");
        System.out.println("Random Array (Size " + randomArr1000.length + "): " + Util.arrayToString(randomArr1000, 10));
        printArray(randomArr1000);

    }
}