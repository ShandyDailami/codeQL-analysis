import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_31848_FileScanner_A03 {
    public static void main(String[] args) {
        File directory = new File(".");
        String extension = ".txt"; // Change to the type of files you want to scan

        File[] listOfFiles = directory.listFiles((dir, name) -> name.endsWith(extension));

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line);
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("File not found: " + file.getPath());
                }
            }
        } else {
            System.out.println("No files found with extension: " + extension);
        }
    }
}