import java.io.File;
import java.util.Scanner;

public class java_03886_FileScanner_A07 {
    public static void main(String[] args) {
        String dirPath = "/path/to/directory"; // Replace with your directory path
        String searchString = "AuthFailure";

        File dir = new File(dirPath);
        File[] files = dir.listFiles((dir1, name) -> name.endsWith(".txt"));

        if (files != null) {
            for (File file : files) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        if (line.contains(searchString)) {
                            System.out.println("File: " + file.getName() + " contains the string: " + searchString);
                        }
                    }
                }
            }
        }
    }
}