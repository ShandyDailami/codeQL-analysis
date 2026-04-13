import java.io.File;
import java.util.Scanner;

public class java_29428_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path: ");
        String path = scanner.nextLine();
        scanner.close();

        File directory = new File(path);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.canRead()) {
                        // Print file name
                        System.out.println("File Name: " + file.getName());

                        // Print file size
                        long size = file.length();
                        System.out.println("File Size: " + size + " bytes");

                        // Print file integrity
                        if (checkIntegrity(file)) {
                            System.out.println("File is secure.");
                        } else {
                            System.out.println("File is not secure.");
                        }

                        // Print file location
                        System.out.println("File Location: " + file.getAbsolutePath());
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist or it is not a directory.");
        }
    }

    private static boolean checkIntegrity(File file) {
        // This is a placeholder for your security-sensitive operation.
        // You should replace this with the actual method that verifies the integrity of a file.
        // For example, you could use a hash algorithm to verify the file's integrity.
        return true;
    }
}