import java.io.File;
import java.util.Scanner;

public class java_41563_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String dirPath = scanner.nextLine();
        scanner.close();

        File directory = new File(dirPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        if (isSensitiveOperation(file)) {
                            System.out.println("File: " + file.getName() + " is a security-sensitive file.");
                        }
                    } else if (file.isDirectory()) {
                        System.out.println("Directory: " + file.getName() + " is a subdirectory.");
                    }
                }
            } else {
                System.out.println("Directory is empty.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }

    // A simple example of a security-sensitive operation. This could be any operation.
    private static boolean isSensitiveOperation(File file) {
        return false;
    }
}