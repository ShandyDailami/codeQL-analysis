import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_12722_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File("."); // current directory
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the file extension:");
        String extension = scanner.next();

        System.out.println("Searching for files with extension: " + extension);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(extension));

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("Found file: " + file.getName());
                }
            }
        } else {
            System.out.println("No files found with extension: " + extension);
        }

        scanner.close();
    }
}