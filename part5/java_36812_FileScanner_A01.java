import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_36812_FileScanner_A01 {

    private final File file;

    public java_36812_FileScanner_A01(File file) {
        this.file = file;
    }

    public List<String> readLines() {
        List<String> lines = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines;
    }

    public void printLines() {
        List<String> lines = readLines();
        for (String line : lines) {
            System.out.println(line);
        }
    }

    public static void main(String[] args) {
        File file = new File("path/to/your/file");
        BrokenAccessControlScanner scanner = new BrokenAccessControlScanner(file);
        scanner.printLines();
    }
}