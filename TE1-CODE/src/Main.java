public class Main {

    public static void doSort(int[] arr){
        int[] copiedArr = new int[arr.length];
        System.arraycopy(arr, 0, copiedArr, 0, arr.length);
        doRadixSort(arr);
        doPeekSort(copiedArr);
    }

    // Radix sort performance
    public static void doRadixSort(int[] arr){
        long radixSortStartTime = System.currentTimeMillis();
        Radixsort.radixSort(arr);
        long radixSortEndTime = System.currentTimeMillis();
        long memoryUsed = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long radixSortResultTime = radixSortEndTime - radixSortStartTime;

        System.out.println("Penggunaan memori Radix Sort: " + memoryUsed + " bytes");
        System.out.println("Waktu eksekusi Radix Sort: " + radixSortResultTime + " ms");
        System.out.println();
    }

    // Peek sort performance
    public static void doPeekSort(int[] arr){
        long peekSortStartTime = System.currentTimeMillis();
        Peeksort.peekSort(arr, 0, arr.length-1, 0, arr.length-1, new int[arr.length]);
        long peekSortEndTime = System.currentTimeMillis();
        long memoryUsed = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long peekSortResultTime = peekSortEndTime - peekSortStartTime;

        System.out.println("Penggunaan memori Peek Sort: " + memoryUsed + " bytes");
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

        System.out.println("==================================================");
        System.out.println("Data Array Sorted");
        System.out.println("==================================================");
        System.out.println("Data 1000 Angka");
        doSort(sortedArr1000);
        System.out.println();
        System.out.println("Data 10000 Angka");
        doSort(sortedArr10000);
        System.out.println();
        System.out.println("Data 100000 Angka");
        doSort(sortedArr100000);
        System.out.println();

        System.out.println("==================================================");
        System.out.println("Data Array Random");
        System.out.println("==================================================");
        System.out.println("Data 1000 Angka");
        doSort(randomArr1000);
        System.out.println();
        System.out.println("Data 10000 Angka");
        doSort(randomArr10000);
        System.out.println();
        System.out.println("Data 100000 Angka");
        doSort(randomArr100000);
        System.out.println();

        System.out.println("==================================================");
        System.out.println("Data Array Reversed");
        System.out.println("==================================================");
        System.out.println("Data 1000 Angka");
        doSort(reversedArr1000);
        System.out.println();
        System.out.println("Data 10000 Angka");
        doSort(reversedArr10000);
        System.out.println();
        System.out.println("Data 100000 Angka");
        doSort(reversedArr100000);

    }
}