import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_32566_FileScanner_A07 {
    private String directoryPath;

    public java_32566_FileScanner_A07(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public void scanFiles() {
        File directory = new File(directoryPath);
        if (directory.exists()) {
            Scanner scanner = new Scanner(System.in);
            scanFilesInDirectory(directory, scanner);
            scanner.close();
        } else {
            System.out.println("Directory does not exist.");
        }
    }

    private void scanFilesInDirectory(File directory, Scanner scanner) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    scanFileForAuthFailure(file, scanner);
                } else if (file.isDirectory()) {
                    scanFilesInDirectory(file, scanner);
                }
            }
        }
    }

    private void scanFileForAuthFailure(File file, Scanner scanner) {
        try {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (line.contains("A07_AuthFailure")) {
                    System.out.println("AuthFailure found in file: " + file.getAbsolutePath());
                }
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getAbsolutePath());
        }
    }
}