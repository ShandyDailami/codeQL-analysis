import java.io.File;
import java.util.Scanner;

public class java_05314_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            searchForInjection(directory);
        } else {
            System.out.println("Invalid directory path!");
        }

        scanner.close();
    }

    private static void searchForInjection(File directory) {
        File[] listOfFiles = directory.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    scanForInjectionInFile(file);
                } else if (file.isDirectory()) {
                    searchForInjection(file);
                }
            }
        }
    }

    private static void scanForInjectionInFile(File file) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Add your logic for checking for injection vulnerabilities here
                // If found, print the line and file name
                System.out.println("Found injection vulnerability in line: " + line + " in file: " + file.getName());
            }
            scanner.close();
        } catch (Exception e) {
            // Handle exceptions as needed
        }
    }
}