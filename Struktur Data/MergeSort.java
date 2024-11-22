import java.util.Arrays;

public class MergeSort {
    // Fungsi untuk menggabungkan dua subarray
    public static void merge(int[] array, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // Membuat array sementara
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Menyalin data ke array sementara
        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[middle + 1 + j];
        }

        // Indeks awal dari kedua subarray
        int i = 0, j = 0;

        // Indeks awal array yang digabungkan
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Salin elemen yang tersisa
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Fungsi utama Merge Sort
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;

            // Rekursi untuk membagi
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);

            // Menggabungkan kembali
            merge(array, left, middle, right);
        }
    }

    public static void main(String[] args) {
        int[] data = {38, 27, 43, 3, 9, 82};
        System.out.println("Data awal: " + Arrays.toString(data));

        mergeSort(data, 0, data.length - 1);
        System.out.println("Data setelah diurutkan (Merge Sort): " + Arrays.toString(data));
    }
}



