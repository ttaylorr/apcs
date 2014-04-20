import java.util.ArrayList;
import java.util.Random;

public class Main {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        Timer timer = new Timer();

        Class<? extends Sort>[] sorts = new Class[]{SelectionSort.class, InsertionSort.class, MergeSort.class};
        int[] sizes = new int[]{10, 100, 200, 500, 1000, 10000};

        for (Class<? extends Sort> clazz : sorts) {
            try {
                Sort s = clazz.newInstance();
                for (int i : sizes) {
                    ArrayList<Integer> arr = randomArrayList(i);
                    timer.start();
                    s.sortList(arr);
                    timer.end();

                    System.out.println(clazz.getName() + " sorted " + i + " elements in " + timer.toString());
                }
            } catch (Exception ignored) {}
        }
    }

    public static ArrayList<Integer> randomArrayList(int i) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        while (result.size() < i) {
            result.add(RANDOM.nextInt());
        }
        return result;
    }

    public static ArrayList<ArrayList<Integer>> arrayListOfArrayLists(int m, int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < m; i++) {
            result.add(randomArrayList(n));
        }

        return result;
    }
}
