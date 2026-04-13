import java.io.File;
import java.util.Scanner;

public class java_40769_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the string to search:");
        String searchString = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] matchingFiles = directory.listFiles((dir, name) -> name.startsWith(searchString));

        if (matchingFiles != null) {
            for (File file : matchingFiles) {
                if (file.isFile()) {
                    System.out.println("Found file: " + file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    System.out.println("Found directory: " + file.getAbsolutePath());
                }
            }
        } else {
            System.out.println("No matching files found.");
        }
    }
}