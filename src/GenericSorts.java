import java.util.ArrayList;
import java.util.List;

public class GenericSorts {

    // Bubble Sort method
    public static <T extends Comparable<T>> void bubbleSort(List<T> list) {
        int n = list.size();
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    // Swap elements if they are in the wrong order
                    T temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    swapped = true;
                }
            }
            
            if (!swapped) break;
        }
    }

    // merge sort
    public static <T extends Comparable<T>> void mergeSort(List<T> list) {
        if (list.size() < 2) {
            return;
        }

        int mid = list.size() / 2;
        List<T> left = new ArrayList<>(list.subList(0, mid));
        List<T> right = new ArrayList<>(list.subList(mid, list.size()));

        mergeSort(left);
        mergeSort(right);
        merge(list, left, right);
    }

    private static <T extends Comparable<T>> void merge(List<T> list, List<T> left, List<T> right) {
        int i = 0, j = 0, k = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).compareTo(right.get(j)) <= 0) {
                list.set(k++, left.get(i++));
            } else {
                list.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) {
            list.set(k++, left.get(i++));
        }

        while (j < right.size()) {
            list.set(k++, right.get(j++));
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(10, 9, 8, 7, 6, 5, 4));
        System.out.println("Original List: " + list);
        bubbleSort(list);
        System.out.println("Sorted List using Bubble Sort: " + list);
        list = new ArrayList<>(List.of(10, 9, 8, 7, 6, 5, 4));
        mergeSort(list);
        System.out.println("Sorted List using Merge Sort: " + list);
    }
}
