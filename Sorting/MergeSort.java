import java.util.ArrayList;

public class MergeSort extends Sort {
    @Override
    public <T extends Comparable<T>> void sortList(ArrayList<T> arr) {
        ArrayList<T> temp = new ArrayList<T>(arr);
        mergeSort(arr, temp, 0, arr.size() - 1);
    }

    private <T extends Comparable<T>> void mergeSort(ArrayList<T> arr, ArrayList<T> temp, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(arr, temp, left, center);
            mergeSort(arr, temp, center + 1, right);

            merge(arr, temp, left, center + 1, right);
        }
    }

    private <T extends Comparable<T>> void merge(ArrayList<T> arr, ArrayList<T> temp, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tempPos = leftPos;
        int num = rightEnd - leftPos + 1;

        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (arr.get(leftPos).compareTo(arr.get(rightPos)) <= 0) {
                temp.set(tempPos++, arr.get(leftPos++));
            } else {
                temp.set(tempPos++, arr.get(rightPos++));
            }
        }

        while (leftPos <= leftEnd) {
            temp.set(tempPos++, arr.get(leftPos++));
        }
        while (rightPos <= rightEnd) {
            temp.set(tempPos++, arr.get(rightPos++));
        }

        for (int i = 0; i < num; i++, rightEnd--) {
            arr.set(rightEnd, temp.get(rightEnd));
        }
    }
}
