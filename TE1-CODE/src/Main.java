public class Main {

    public static void doSort(int[] arr){
        int[] copiedArr = new int[arr.length];
        System.arraycopy(arr, 0, copiedArr, 0, arr.length);

        // Radix sort performance
        System.out.println("Array sebelum Radix Sort");
        System.out.println("Array (Size " + arr.length + "): " + Util.arrayToString(arr, 100));
        System.out.println();

        long initialMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long radixSortStartTime = System.currentTimeMillis();
        Radixsort.radixSort(arr);
        long radixSortEndTime = System.currentTimeMillis();
        long finalMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long radixSortResultTime = radixSortEndTime - radixSortStartTime;
        long memoryUsed = finalMemory - initialMemory;

        System.out.println("Array setelah Radix Sort");
        System.out.println("Array (Size " + arr.length + "): " + Util.arrayToString(arr, 100));
        System.out.println();

        System.out.println("Memory used by the sorting algorithm: " + memoryUsed + " bytes");
        System.out.println("Waktu eksekusi Radix Sort: " + radixSortResultTime + " ms");
        System.out.println();


        // Peek sort performance
        System.out.println("Array sebelum Peek Sort");
        System.out.println("Array (Size " + copiedArr.length + "): " + Util.arrayToString(copiedArr, 100));
        System.out.println();

        long initialMemory2 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long peekSortStartTime = System.currentTimeMillis();
        Peeksort.peekSort(copiedArr, 0, copiedArr.length-1, 0, copiedArr.length-1, new int[copiedArr.length]);
        long peekSortEndTime = System.currentTimeMillis();
        long finalMemory2 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long peekSortResultTime = peekSortEndTime - peekSortStartTime;
        long memoryUsed2 = finalMemory2 - initialMemory2;


        System.out.println("Array setelah Peek Sort");
        System.out.println("Array (Size " + copiedArr.length + "): " + Util.arrayToString(copiedArr, 100));
        System.out.println();

        System.out.println("Memory used by the sorting algorithm: " + memoryUsed2 + " bytes");
        System.out.println("Waktu eksekusi Peek Sort: " + peekSortResultTime + " ms");
        System.out.println();
    }
    public static void main(String[] args) {
        // create sorted array
        int[] sortedArr1000 = Util.createSortedData(1000);
        int[] sortedArr10000 = Util.createSortedData(10000);
        int[] sortedArr100000 = Util.createSortedData(100000);

        // create random array
        int[] randomArr1000 = Util.createRandomData(1000);
        int[] randomArr10000 = Util.createRandomData(10000);
        int[] randomArr100000 = Util.createRandomData(100000);

        // create reversed array
        int[] reversedArr1000 = Util.createReversedList(1000);
        int[] reversedArr10000 = Util.createReversedList(10000);
        int[] reversedArr100000 = Util.createReversedList(100000);


        System.out.println("Data 1000 Angka Sorted");
        doSort(sortedArr1000);
        System.out.println();
        System.out.println("Data 10000 Angka Sorted");
        doSort(sortedArr10000);
        System.out.println();
        System.out.println("Data 100000 Angka Sorted");
        doSort(sortedArr100000);
        System.out.println();

        System.out.println("==================================================\n");

        System.out.println("Data 1000 Angka Random");
        doSort(randomArr1000);
        System.out.println();
        System.out.println("Data 10000 Angka Random");
        doSort(randomArr10000);
        System.out.println();
        System.out.println("Data 100000 Angka Random");
        doSort(randomArr100000);
        System.out.println();

        System.out.println("==================================================\n");

        System.out.println("Data 1000 Angka Reversed");
        doSort(reversedArr1000);
        System.out.println();
        System.out.println("Data 10000 Angka Reversed");
        doSort(reversedArr10000);
        System.out.println();
        System.out.println("Data 100000 Angka Reversed");
        doSort(reversedArr100000);

    }
}