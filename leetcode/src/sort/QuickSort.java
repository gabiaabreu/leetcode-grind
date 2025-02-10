package sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2};
        quickSort(arr, 0, arr.length - 1);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) { // else - already ordered
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1); // sort left part
            quickSort(arr, pivotIndex + 1, high); // sort right part
        }
    }

    private static int partition(int[] arr, int low, int high) {
        // pick pivot - last item
        int pivot = arr[high];
        int i = low;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) { // if current < pivot, switch i and j
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++; // increment i and j (on for loop)
            } // if current > pivot, do nothing and increment only j on for loop
        }

        // insert pivot on right place
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;

        return i; // return pivot position
    }
}
