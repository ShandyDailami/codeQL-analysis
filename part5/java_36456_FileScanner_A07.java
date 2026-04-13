import java.io.File;
import java.util.Scanner;

public class java_36456_FileScanner_A07 {

    private String directoryPath;
    private File directory;

    public java_36456_FileScanner_A07(String directoryPath) {
        this.directoryPath = directoryPath;
        this.directory = new File(directoryPath);
    }

    public void scanDirectory() {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && isFileSafe(file)) {
                    System.out.println("Found safe file: " + file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    scanDirectory();
                }
            }
        }
    }

    private boolean isFileSafe(File file) {
        // Implement your security-sensitive operations here
        // For example, check if the file is executable or if it contains a certain pattern
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();
        SecureFileScanner scannerImpl = new SecureFileScanner(directoryPath);
        scannerImpl.scanDirectory();
    }
}