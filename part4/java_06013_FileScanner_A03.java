import java.io.File;
import java.util.Scanner;

public class java_06013_FileScanner_A03 {

    public static void main(String[] args) {

        // Prompt the user for the directory they want to scan
        System.out.println("Please enter the directory you want to scan:");
        Scanner scanner = new Scanner(System.in);
        String directoryPath = scanner.nextLine();
        scanner.close();

        // Use the FileScanner to scan the directory
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    // Here we only print out the file name and size
                    // For security-sensitive operations, you should probably add a check
                    // here to see if the file is executable or not, or to see if it's a
                    // known executable file type, etc.
                    System.out.println("File: " + file.getName() + ", Size: " + file.length() + " bytes");
                }
            }
        }
    }
}