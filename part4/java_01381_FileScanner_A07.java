import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_01381_FileScanner_A07 {

    private static String directoryPath;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path: ");
        directoryPath = scanner.nextLine();

        try {
            File directory = new File(directoryPath);

            if (!directory.exists()) {
                System.out.println("Directory does not exist!");
                return;
            }

            if (directory.listFiles() == null) {
                System.out.println("Directory is empty!");
                return;
            }

            File[] allFiles = directory.listFiles();

            for (File file : allFiles) {
                if (file.isFile()) {
                    handleFile(file);
                }
            }

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static void handleFile(File file) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Add security-sensitive operations here.
                // For example, you might consider removing certain characters from the line if they pose a security risk.
                // Here, I'll just print the line.
                System.out.println(line);
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Failed to read file: " + file.getName());
        }
    }
}