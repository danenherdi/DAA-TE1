public class Peeksort {

    // Method untuk menggabungkan dua bagian array
    public static void merge(int[] A, int left, int mid, int right, int[] B) {
        mid -= 1;

        // menyalin setengah bagian kiri array A ke array B
        int i = mid + 1;
        while(i > left){
            B[i-1] = A[i-1];
            --i;
        }

        // menyalin bagian kanan array A ke array B dengan urutan terbalik
        int j = mid;
        while (j < right) {
            B[right + mid - j] = A[j + 1];
            ++j;
        }

        // merge kembali elemen ke array A dengan pengurutan
        int k = left;
        while (k <= right) {

            // kondisi ketika elemen di setengah bagian kanan lebih kecil
            if (B[j] < B[i]) {
                A[k] = B[j--];
            }
            // kondisi ketika elemen di setengah bagian kiri lebih kecil atau sama
            else {
                A[k] = B[i++];
            }
            ++k;
        }
    }

    // Method untuk mencari index elemen paling kiri ketika mulai pengurutan angka mulai tidak mengurut naik
    public static int extendRunLeftInc(int[] A, int i, int left) {
        while (i > left && A[i-1] <= A[i]){
            --i;
        }
        return i;
    }

    // Method untuk mencari index elemen paling kanan ketika mulai pengurutan angka mulai tidak mengurut naik
    public static int extendRunRightInc(int[] A, int i, int right) {
        while (i < right && A[i+1] >= A[i]){
            ++i;
        }
        return i;
    }

    // Method untuk mencari index elemen paling kiri ketika mulai pengurutan angka mulai tidak mengurut turun
    public static int extendRunLeftDec(int[] A, int i, int left) {
        while (i > left && A[i-1] > A[i]){
            --i;
        }
        return i;
    }

    // Method untuk mencari index elemen paling kanan ketika mulai pengurutan angka mulai tidak mengurut turun
    public static int extendRunRightDec(int[] A, int i, int right) {
        while (i < right && A[i+1] < A[i]){
            ++i;
        }
        return i;
    }

    // Method untuk reverse elemen dengan jarak range tertentu
    public static void reverse(int[] A, int low, int high) {
        while (low < high) {
            int temp = A[low];
            A[low++] = A[high];
            A[high--] = temp;
        }
    }

    // Method untuk melakukan Peek Sort
    public static void peekSort(int[] A, int left, int right, int leftEnd, int rightStart, int[] B) {
        // base case untuk kondisi ketika index sudah mencapai ujung kiri dan kanan
        if (leftEnd == right || rightStart == left) {
            return;
        }

        // mencari index titik tengah array
        int mid = left + (int) Math.floor((right - left) / 2.0);

        // kondisi ketika index tengah berada sebelum akhir dari kiri bagian array
        if (mid <= leftEnd) {
            // sorting setengah bagian kanan array dan merge kembali
            peekSort(A, leftEnd+1, right, leftEnd+1,rightStart, B);
            merge(A, left, leftEnd+1, right, B);
        }
        // kondisi ketika index tengah berada setelah awal dari kanan bagian array
        else if (mid >= rightStart) {
            // sorting setengah bagian kiri array dan merge kembali
            peekSort(A, left, rightStart-1, leftEnd, rightStart-1, B);
            merge(A, left, rightStart, right, B);
        }
        // kondisi mencari sisa pengurutan (run)
        else {
            int i, j;

            // kondisi ketika elemen tengah masih lebih kecil dari sebelah kanannya
            if (A[mid] <= A[mid+1]) {
                // kondisi ketika index kiri sudah sama dengan index akhir dari setengah bagian kiri array
                if (left == leftEnd){
                    i = extendRunLeftInc(A, mid, left);
                }
                else{
                    i = extendRunLeftInc(A, mid, leftEnd+1);
                }

                // kondisi ketika bagian kanan index tengah sudah sama dengan index awal dari setengah bagian kanan array
                if(mid+1 == rightStart){
                    j = mid;
                }
                else{
                    // kondisi ketika index kanan sudah sama dengan index awal dari setengah bagian kanan array
                    if (right == rightStart){
                        j = extendRunRightInc(A, mid + 1, right);
                    }
                    else{
                        j = extendRunRightInc(A, mid + 1, rightStart - 1);
                    }
                }
            }
            // jika tidak maka cek urutan array terbalik (decreasing order)
            else {
                if (left == leftEnd){
                    i = extendRunLeftDec(A, mid, left);
                }
                else{
                    i = extendRunLeftDec(A, mid, leftEnd+1);
                }

                if (mid + 1 == rightStart){
                    j = mid;
                }
                else{
                    if (right == rightStart){
                        j = extendRunRightDec(A, mid+1,right);
                    }
                    else{
                        j = extendRunRightDec(A, mid+1, rightStart-1);
                    }
                }

                // Setelah didapatkan indeks awal dan akhir urutan mulainya
                // terbalik maka dilakukan reverse order pada range tersebut
                reverse(A, i, j);
            }

            // index kiri dan kanan sama maka bagian array sudah sorted
            if (i == left && j == right){
                return;
            }

            // Kondisi ketika setengah bagian kanan array masih banyak yang perlu disortir
            if (mid - i < j - mid) {
                peekSort(A, left, i-1, leftEnd, i-1, B);
                peekSort(A, i, right, j, rightStart, B);
                merge(A,left, i, right, B);
            }
            // Kondisi ketika setengah bagian kiri array masih banyak yang perlu disortir
            else {
                peekSort(A, left, j, leftEnd, i, B);
                peekSort(A, j+1, right, j+1, rightStart, B);
                merge(A,left, j+1, right, B);
            }
        }
    }
}
