import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_41366_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        try {
            File directory = new File(directoryPath);
            File[] allFiles = directory.listFiles();
            if (allFiles != null) {
                for (File file : allFiles) {
                    if (file.isFile()) {
                        if (file.getName().endsWith(".txt")) {
                            readFile(file);
                        }
                    } else if (file.isDirectory()) {
                        readDirectory(file);
                    }
                }
            } else {
                System.out.println("No files or directories found in the provided directory!");
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("An error occurred while processing the request. Please try again.");
        }
    }

    private static void readFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // This is a security-sensitive operation, so we are only printing the line
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getPath());
        }
    }

    private static void readDirectory(File directory) {
        try (Scanner scanner = new Scanner(directory.listFiles())) {
            while (scanner.hasNext()) {
                File file = scanner.nextFile();
                if (file.isFile()) {
                    if (file.getName().endsWith(".txt")) {
                        readFile(file);
                    }
                } else if (file.isDirectory()) {
                    readDirectory(file);
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred while processing the request. Please try again.");
        }
    }
}