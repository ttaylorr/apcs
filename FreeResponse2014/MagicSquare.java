public class MagicSquare {

    private final int size;
    private int[][] arr;

    public MagicSquare(int[][] arr) {
        this.arr = arr;
        this.size = arr == null ? 0 : arr.length;
    }

    public void writeMatrix() {
        return; // implementation not shown
    }

    public int sumRow(int n) {
        int r = 0;
        for (int i : arr[n]) {
            r += i;
        }

        return r;
    }

    public int sumCol(int n) {
        return -1; // implementation not shown
    }

    public int sumMajorDiag() {
        return -1; // implementation not shown
    }

    public int sumMinorDiag() {
        int x = this.size;
        int y = this.size;

        int result = arr[x][y];

        while (x > 0 && y > 0) {
            try {
                result += this.arr[x--][y--];
            } catch (ArrayIndexOutOfBoundsException e) {
                break;
            }
        }

        return result;
    }

    public boolean isMagic() {
        int magic = this.sumCol(0);
        for (int i = 0; i < this.size; i++) {
            if (magic != this.sumCol(i) || magic != this.sumRow(i)) {
                return false;
            }
        }

        return this.sumMajorDiag() == magic && this.sumMinorDiag() == magic;
    }
}
