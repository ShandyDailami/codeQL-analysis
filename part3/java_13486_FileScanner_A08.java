import java.io.File;
import java.util.Scanner;

public class java_13486_FileScanner_A08 {
    public static void main(String[] args) {
        // Prompt user for directory
        System.out.println("Please enter a directory:");
        Scanner scanner = new Scanner(System.in);
        String directoryPath = scanner.nextLine();

        // Get directory
        File directory = new File(directoryPath);

        // List all files in directory
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getAbsolutePath());
                }
            }
        } else {
            System.out.println("The directory does not exist.");
        }
    }
}