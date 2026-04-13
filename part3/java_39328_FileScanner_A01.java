import java.io.File;
import java.util.Scanner;

public class java_39328_FileScanner_A01 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the directory path:");
            String directoryPath = scanner.nextLine();

            File directory = new File(directoryPath);

            if (!directory.exists()) {
                System.out.println("Directory does not exist!");
                return;
            }

            if (!directory.isDirectory()) {
                System.out.println("Provided path is not a directory!");
                return;
            }

            File[] files = directory.listFiles();

            if (files == null) {
                System.out.println("Failed to list files in the directory!");
                return;
            }

            for (File file : files) {
                if (file.isFile() && file.canRead()) {
                    System.out.println("Reading file: " + file.getName());
                    Scanner fileScanner = new Scanner(file);
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        System.out.println("Line: " + line);
                   
                        // This is a simple example of a security-sensitive operation.
                        // In a real-world scenario, you would need to implement
                        // additional security measures such as access control.
                        // However, for the sake of simplicity, we won't implement
                        // access control in this example.
                    }
                    fileScanner.close();
                }
            }

            scanner.close();
        } catch (Exception e) {
            System.out.println("An error occurred while scanning the directory!");
        }
    }
}