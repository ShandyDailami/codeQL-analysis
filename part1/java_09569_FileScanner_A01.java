import java.io.File;
import java.util.Scanner;

public class java_09569_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        try {
            File directory = new File(directoryPath);
            File[] hiddenFiles = directory.listFiles(file -> file.isHidden());

            for (File hiddenFile : hiddenFiles) {
                if (hiddenFile.isFile()) {
                    System.out.println("Found a hidden file: " + hiddenFile.getName());
                } else if (hiddenFile.isDirectory()) {
                    System.out.println("Found a hidden directory: " + hiddenFile.getName());
                }
            }
        } catch (Exception e) {
            System.out.println("Error while accessing directory: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}