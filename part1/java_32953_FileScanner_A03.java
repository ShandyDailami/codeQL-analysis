import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_32953_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the path to the directory: ");
        String path = scanner.nextLine();

        try {
            File file = new File(path);
            scanDirectory(file);
        } catch (FileNotFoundException e) {
            System.out.println("Invalid path");
        } finally {
            scanner.close();
        }
    }

    private static void scanDirectory(File file) throws FileNotFoundException {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    if (f.isDirectory()) {
                        scanDirectory(f);
                    } else {
                        processFile(f);
                    }
                }
            }
        } else {
            processFile(file);
        }
    }

    private static void processFile(File file) throws FileNotFoundException {
        if (isSensitiveOperation(file)) {
            performSensitiveOperation(file);
        }
    }

    private static boolean isSensitiveOperation(File file) {
        // Implement your own logic here
        return false;
    }

    private static void performSensitiveOperation(File file) throws FileNotFoundException {
        // Implement your own logic here
    }
}