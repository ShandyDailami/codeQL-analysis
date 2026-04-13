import java.io.File;
import java.util.Scanner;

public class java_11257_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the file name pattern (e.g., *.txt):");
        String fileNamePattern = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] filesInDirectory = directory.listFiles((dir, name) -> name.matches(fileNamePattern));

        if (filesInDirectory != null) {
            for (File file : filesInDirectory) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getAbsolutePath());
                }
            }
        } else {
            System.out.println("No files found in the directory!");
        }

        scanner.close();
    }
}