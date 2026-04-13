import java.io.File;
import java.util.Scanner;

public class java_13469_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        try {
            File directory = new File(directoryPath);
            File[] hiddenFiles = directory.listFiles(file -> file.isHidden() && file.canRead());

            if (hiddenFiles != null) {
                for (File file : hiddenFiles) {
                    System.out.println("File: " + file.getName());
                }
            } else {
                System.out.println("No hidden files or readable files found.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while trying to access the directory: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}