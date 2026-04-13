import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_28062_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory path");
            return;
        }

        System.out.println("Scanning for .txt files in " + directory.getAbsolutePath());
        try (FileScanner fileScanner = new FileScanner(directory)) {
            fileScanner.scan(FileKind.FILES_ONLY, ".txt");
            fileScanner.filterAccept(".txt");
            while (fileScanner.hasNext()) {
                File file = fileScanner.nextFile();
                System.out.println("Found file: " + file.getAbsolutePath());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}