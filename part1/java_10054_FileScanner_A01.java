import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_10054_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "src/main/java/"; // specify your directory here
        File directory = new File(directoryPath);

        // Ensure the directory exists
        if (!directory.exists()) {
            System.out.println("The directory does not exist!");
            return;
        }

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                }
            }
        }
    }
}