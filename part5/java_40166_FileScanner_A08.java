import java.io.File;
import java.util.Scanner;

public class java_40166_FileScanner_A08 {
    private String directoryPath;

    public java_40166_FileScanner_A08(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public void scanDirectory() {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getAbsolutePath());
                    verifyIntegrity(file);
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getAbsolutePath());
                    scanDirectory();
                }
            }
        }
    }

    private void verifyIntegrity(File file) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Insert your integrity verification code here
                // For example, verify if the file has the right permissions
                if (!file.canRead(file)) {
                    System.out.println("Integrity failure detected in file: " + file.getAbsolutePath());
                }
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("An error occurred while scanning file: " + file.getAbsolutePath());
        }
    }

    public static void main(String[] args) {
        FileScanner fileScanner = new FileScanner("/path/to/directory");
        fileScanner.scanDirectory();
    }
}