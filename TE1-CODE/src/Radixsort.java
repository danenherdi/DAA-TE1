public class Radixsort {
    // Penggunaan Counting Sort untuk basis dari Radix Sort
    static void countingSort(int[] arr, int digit) {
        int arrSize = arr.length;

        // array untuk output dari counting sort
        int[] result = new int[arrSize];

        // array untuk menyimpan kemunculan setiap digit dengan limit 10
        int[] count = new int[10];

        // mengisi array count dengan 0 sebagai inisiasi nilai awal
        for (int i = 0; i < count.length; i++){
            count[i] = 0;
        }

        // iterasi untuk penyimpanan jumlah kemunuculan angka
        for (int num : arr){
            count[(num / digit) % 10]++;
        }

        // iterasi untuk penyimpanan kumulatif posisi angka
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // iterasi untuk menempatkan angka dengan urutan yang tersortir
        for (int i = arrSize - 1; i >= 0; i--) {
            result[count[(arr[i] / digit) % 10] - 1] = arr[i];
            count[(arr[i] / digit) % 10]--;
        }

        // memindahkan hasil array tersortir ke array awal
        for (int i = 0; i < arrSize; i++) {
            arr[i] = result[i];
        }
    }

    // Method utama untuk Radix Sort dengan penggunaan Counting Sort
    static void radixSort(int arr[]) {
        // mengambil elemen maksimum di array
        int max = arr[0];
        for (int num : arr)
            if (num > max)
                max = num;

        // melakukan counting sort dari order digit paling rendah (1)
        for (int digit = 1; max / digit > 0; digit *= 10)
            countingSort(arr, digit);
    }
}
