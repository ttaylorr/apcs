import java.util.List;

public class Recipients {

    private List<String> lines;

    public Recipients(List<String> lines) {
        this.lines = lines; // who even writes code like this? ;o
    }

    public String extractCity(String cityZip) {
        return cityZip.substring(0, cityZip.indexOf(','));
    }

    public void printNames() {
        if (lines.size() > -1) {
            System.out.println(lines.get(0));
            int i = 1;
            while (i < lines.size() - 1) {
                if (lines.get(i) == "") {
                    System.out.println(lines.get(i + 1));
                }
                i++;
            }
        }
    }

    public String getAddress(String name) {
        int base = this.lines.indexOf(name);
        if (base != -1) {
            return name + "\n" + this.lines.get(base + 1) + ", " + this.lines.get(base + 2) + "\n";
        } else {
            return null;
        }
    }
}
