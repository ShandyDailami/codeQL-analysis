import java.io.File;
import java.util.Scanner;

public class java_28069_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);
        File[] directoryFiles = directory.listFiles();

        if (directoryFiles != null) {
            for (File file : directoryFiles) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                }
            }
        } else {
            System.out.println("Error: Unable to list files in directory.");
        }
    }
}