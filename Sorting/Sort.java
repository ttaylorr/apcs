import java.util.ArrayList;

public abstract class Sort {

    public abstract <T extends Comparable<T>> void sortList(ArrayList<T> arr);

    public <T> void swap(ArrayList<T> arr, int i, int j) {
        T temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
}
