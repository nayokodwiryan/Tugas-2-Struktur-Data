import java.util.Arrays;

public class CountingSort {
    public static void countingSort(int[] array) {
        // Cari nilai maksimum dalam array
        int max = Arrays.stream(array).max().getAsInt();

        // Buat array count
        int[] count = new int[max + 1];

        // Hitung frekuensi setiap elemen
        for (int num : array) {
            count[num]++;
        }

        // Rekonstruksi array
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                array[index++] = i;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] data = {38, 27, 43, 3, 9, 82};
        System.out.println("Data awal: " + Arrays.toString(data));

        countingSort(data);
        System.out.println("Data setelah diurutkan (Counting Sort): " + Arrays.toString(data));
    }
}




