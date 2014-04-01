import java.io.*;

public class BinarySearch {

    private static int[] arr;
    public static final int NOT_FOUND = -1;

    public static void main(String[] args) throws IOException {
        arr = new int[500];

        BufferedReader reader = new BufferedReader(new FileReader(new File("./NUMBERS.txt")));
        int i = 0;
        while (reader.ready()) {
            try {
                int n = Integer.parseInt(reader.readLine());
                arr[i] = n;
                i++;
            } catch (NumberFormatException ignored) {}
        }

        // Flip the order of the array if it's descending
        if (arr.length > 2 && arr[0] > arr[1]) {
            for (int e = 0; e < arr.length / 2; e++) {
                int t = arr[e];
                arr[e] = arr[arr.length - e - 1];
                arr[arr.length - e - 1] = t;
            }
        }

        int search_a = 904; // should return true
        int search_b = 970; // should return 2

        System.out.println("Contains " + search_a + "? " + contains(arr, search_a));
        System.out.println("Instances of: " + search_b + "? " + instances(arr, search_b));
    }

    public static boolean contains(int[] arr, int target) {
        return binaryIndexOf(arr, target) != NOT_FOUND;
    }

    public static int binaryIndexOf(int[] arr, int target) {
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (arr[mid] > target) {
                max = mid - 1;
            } else if (arr[mid] < target) {
                min = mid + 1;
            } else {
                return mid;
            }
        }

        return NOT_FOUND;
    }


    public static int instances(int[] arr, int target) {
        int instances = 0;

        for (int i : arr) {
            if (i == target) {
                instances++;
            }
        }

        return instances;
    }
}
