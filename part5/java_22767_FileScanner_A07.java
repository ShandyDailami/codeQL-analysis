import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;

public class java_22767_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Scanning files in " + directory.getAbsolutePath());
            File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

            if (txtFiles != null) {
                for (File txtFile : txtFiles) {
                    try {
                        Files.lines(Paths.get(txtFile.getAbsolutePath()))
                             .forEach(System.out::println);
                    } catch (FileNotFoundException e) {
                        System.out.println("Error occurred while processing file: " + txtFile.getName());
                    }
                }
            } else {
                System.out.println("No .txt files found in " + directory.getAbsolutePath());
            }
        } else {
            System.out.println("Invalid or non-existing directory");
        }
    }
}