import java.io.File;
import java.util.Scanner;

public class java_40874_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.next();
        System.out.println("Enter the file name:");
        String fileName = scanner.next();

        FileScanner fileScanner = new FileScanner(directoryPath, fileName);
        fileScanner.scanDirectory();
    }
}

class FileScanner {
    private String directoryPath;
    private String fileName;

    public java_40874_FileScanner_A08(String directoryPath, String fileName) {
        this.directoryPath = directoryPath;
        this.fileName = fileName;
    }

    public void scanDirectory() {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.getName().equals(fileName)) {
                    System.out.println("File found!");
                    return;
                }

                if (file.isDirectory()) {
                    scanDirectory(file);
                }
            }
        }

        System.out.println("File not found!");
    }

    private void scanDirectory(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.getName().equals(fileName)) {
                    System.out.println("File found in subdirectory!");
                    return;
                }

                if (file.isDirectory()) {
                    scanDirectory(file);
                }
            }
        }
    }
}