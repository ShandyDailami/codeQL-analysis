import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_34068_FileScanner_A08 {
    public static void main(String[] args) {
        // Scan a directory and print out information about each file
        String directoryPath = "/path/to/directory";
        String extension = ".txt";

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(extension)) {
                try {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        System.out.println(scanner.nextLine());
                    }
                    scanner.close();
                } catch (FileNotFoundException e) {
                    System.out.println("Error opening file: " + file.getName());
                }
            }
        }
    }
}