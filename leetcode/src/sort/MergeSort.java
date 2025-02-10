package sort;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        mergeSort(arr, 0, arr.length - 1);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2; // Encontra o meio

            // Passo 1: Divide o array em duas partes
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Passo 2: Conquista e mescla as partes ordenadas
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        // Tamanhos dos subarrays
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Criar subarrays temporários
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        // Copiar os dados para os subarrays
        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        // Índices para percorrer os subarrays
        int i = 0, j = 0, k = left;

        // Mesclar os arrays temporários de volta ao original
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        // Copiar os elementos restantes de leftArr (se houver)
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        // Copiar os elementos restantes de rightArr (se houver)
        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
}
