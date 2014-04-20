import java.util.ArrayList;

public class SelectionSort extends Sort {

    @Override
    public <T extends Comparable<T>> void sortList(ArrayList<T> arr) {
        int i, k, posMax;
        for (i = arr.size() - 1; i > 0; i--) {
            posMax = 0;
            for (k = 1; k <= i; k++) {
                T next = arr.get(k);
                if (next.compareTo(arr.get(posMax)) > 0) {
                    posMax = k;
                }
            }
            swap(arr, i, posMax);
        }
    }

}
