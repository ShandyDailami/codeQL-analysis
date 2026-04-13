import java.io.File;
import java.util.Scanner;

public class java_26699_FileScanner_A03 {
    public static void main(String[] args) {
        // Create a FileScanner for the current directory
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory:");
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            System.out.println("Directory does not exist.");
            System.exit(1);
        }

        // Scan the directory
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                }
            }
        }

        scanner.close();
    }
}