import java.util.ArrayList;

public class InsertionSort extends Sort {
    @Override
    public <T extends Comparable<T>> void sortList(ArrayList<T> arr) {
        for (int i = 1; i < arr.size(); i++) {
            T next = arr.get(i);

            int j = i;
            while (j > 0 && arr.get(j - 1).compareTo(next) > 0) {
                arr.set(j, arr.get(j - 1));
                j--;
            }

            arr.set(j, next);
        }
    }
}
