import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_09355_FileScanner_A08 {
    private String directoryPath;
    private String extension;

    public java_09355_FileScanner_A08(String directoryPath, String extension) {
        this.directoryPath = directoryPath;
        this.extension = extension;
    }

    public void scanFiles() {
        File directory = new File(directoryPath);

        // Check if the directory exists and is readable
        if (!directory.exists() || !directory.isReadable()) {
            System.out.println("Directory not found or not readable.");
            return;
        }

        File[] files = directory.listFiles((dir, name) -> name.endsWith(extension));

        if (files == null) {
            System.out.println("No files found with the specified extension.");
            return;
        }

        for (File file : files) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    System.out.println("Line: " + scanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + file.getAbsolutePath());
            }
        }
    }

    public static void main(String[] args) {
        FileScanner scanner = new FileScanner("/path/to/directory", ".txt");
        scanner.scanFiles();
    }
}