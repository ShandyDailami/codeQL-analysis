import java.io.File;
import java.util.Scanner;

public class java_22477_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Starting file scanner...");
            fileScanner(directory);
        } else {
            System.out.println("Invalid directory path!");
        }
        scanner.close();
    }

    private static void fileScanner(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    // Use a real-life example of security-sensitive operation here.
                    // For example, check the file name for injection attacks.
                    if (file.getName().contains("injection")) {
                        System.out.println("Suspicious file found: " + file.getName());
                    }
                } else if (file.isDirectory()) {
                    fileScanner(file);
                }
            }
        }
    }
}