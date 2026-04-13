import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_20379_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File(".");
        String[] list = directory.list();

        if (list == null) {
            System.out.println("No files found.");
            return;
        }

        for (String fileName : list) {
            File file = new File(fileName);

            if (file.isFile() && file.canRead() && !file.isHidden()) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        System.out.println(scanner.nextLine());
                    }
                }
            }
        }
    }
}