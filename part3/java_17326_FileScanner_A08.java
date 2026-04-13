import java.io.File;
import java.util.Scanner;

public class java_17326_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    checkFileIntegrity(file);
                }
            }
        }

        scanner.close();
    }

    private static void checkFileIntegrity(File file) {
        try {
            byte[] fileContent = new byte[(int) file.length()];
            FileInputStream fis = new FileInputStream(file);
            fis.read(fileContent);
            fis.close();

            // Here is a place where you could add your security-sensitive operation.
            // For example, you can check the hash of the file content to ensure its integrity.
            // Note that you need to add the appropriate security library to your project.
            // For instance, in Java, you can use the MessageDigest class:
            // MessageDigest md = MessageDigest.getInstance("MD5");
            // byte[] thedigest = md.digest(fileContent);

            // You can then compare the computed hash with the hash you have stored in the file.

        } catch (Exception e) {
            System.out.println("Error checking file integrity: " + file.getName());
        }
    }
}