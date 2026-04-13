import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_38064_FileScanner_A07 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // Replace with your directory path
        String subDirectoryPath = "/path/to/subdirectory";  // Replace with your subdirectory path

        File directory = new File(directoryPath);
        File[] subFiles = subDirectoryPath.equals("") ? directory.listFiles() : directory.listFiles(file -> file.getName().endsWith(".txt"));

        if (subFiles == null) {
            System.out.println("No files found!");
            return;
        }

        for (File file : subFiles) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.contains("authFailure")) {
                        System.out.println("Auth failure detected in: " + file.getPath());
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + file.getPath());
            }
        }
    }
}