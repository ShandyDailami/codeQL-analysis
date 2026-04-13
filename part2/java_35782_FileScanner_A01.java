import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_35782_FileScanner_A01 {
    private final String directoryPath;

    public java_35782_FileScanner_A01(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public void scanFiles() {
        File directory = new File(directoryPath);
        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        try (Scanner scanner = new Scanner(file)) {
                            while (scanner.hasNextLine()) {
                                String line = scanner.nextLine();
                                // Handle file content, for example, print it
                                System.out.println("Line in file: " + line);
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    } else if (file.isDirectory()) {
                        // Recursively scan subdirectories
                        scanFiles(file);
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }

    private void scanFiles(File file) {
        if (file.isFile()) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    // Handle file content, for example, print it
                    System.out.println("Line in file: " + line);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File subfile : files) {
                    // Recursively scan subdirectories
                    scanFiles(subfile);
                }
            }
        }
    }
}