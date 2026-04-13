import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_13769_FileScanner_A03 {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter directory path: ");
            String directoryPath = scanner.nextLine();
            File directory = new File(directoryPath);

            if (directory.exists() && directory.isDirectory()) {
                scanFilesInDirectory(directory);
            } else {
                System.out.println("Invalid directory path or it does not exist.");
            }

            scanner.close();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static void scanFilesInDirectory(File directory) throws FileNotFoundException {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    scanFileForInjections(file);
                } else if (file.isDirectory()) {
                    scanFilesInDirectory(file);
                }
            }
        }
    }

    private static void scanFileForInjections(File file) throws FileNotFoundException {
        if (file.canRead()) {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Injection code here (e.g., check for SQL injections, XSS injections, etc.)
            }
            scanner.close();
        }
    }
}