import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_21366_FileScanner_A03 {
    private String directoryPath;

    public java_21366_FileScanner_A03(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public void scanDirectory() {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            // Here is the security-sensitive operation related to A03_Injection
                            // For instance, it's here to print the file content
                            System.out.println(line);
                        }
                        scanner.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found: " + file.getAbsolutePath());
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        SecureFileScanner scanner = new SecureFileScanner("/path/to/directory");
        scanner.scanDirectory();
    }
}