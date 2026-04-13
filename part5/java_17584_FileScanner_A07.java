import java.io.File;
import java.util.Scanner;
import java.util.Locale;

public class java_17584_FileScanner_A07 {
    public static void main(String[] args) {
        File directory = new File("./"); // change this to the directory you want to scan

        String[] extensions = { ".txt", ".java" }; // change this to the file extensions you want to scan

        File[] files = directory.listFiles((dir, name) -> {
            for (String ext : extensions) {
                if (name.toLowerCase(Locale.ROOT).endsWith(ext)) {
                    return true;
                }
            }
            return false;
        });

        if (files != null) {
            for (File file : files) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line); // replace this with your own logic
                    }
                }
            }
        }
    }
}