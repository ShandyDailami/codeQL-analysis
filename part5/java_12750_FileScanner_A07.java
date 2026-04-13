import java.io.File;
import java.util.Scanner;

public class java_12750_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            for (File file : files) {
                if (file.getName().endsWith(".txt") && file.canRead()) {
                    try (Scanner textScanner = new Scanner(file)) {
                        while (textScanner.hasNextLine()) {
                            String line = textScanner.nextLine();
                            // Add your security-sensitive operations here
                        }
                    } catch (Exception e) {
                        System.out.println("Error processing file: " + file.getName());
                    }
                }
            }
        } else {
            System.out.println("The provided path is not a valid directory.");
        }

        scanner.close();
    }
}