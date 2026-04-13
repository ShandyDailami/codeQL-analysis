import java.io.File;
import java.io.FileFilter;
import java.util.Scanner;

public class java_14953_FileScanner_A01 {

    public static void main(String[] args) {
        File directory = new File(".");
        File[] files = directory.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.canRead();
            }
        });

        for (File file : files) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                }
            }
        }
    }
}