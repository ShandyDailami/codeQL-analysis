import java.io.File;
import java.util.Scanner;

public class java_28598_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            if (directory.isDirectory()) {
                System.out.println("Scanning files in directory: " + directoryPath);

                String[] files = directory.list();

                for (String fileName : files) {
                    File file = new File(directoryPath + "/" + fileName);

                    if (file.isFile()) {
                        System.out.println("Found file: " + file.getName());

                        // Add your security-sensitive operations here.
                        // This is just a placeholder, real operations would depend on your application's requirements.

                        // For example, you might check the file's integrity:

                        if (!file.canRead()) {
                            System.out.println("Cannot read file: " + file.getName());
                        } else {
                            System.out.println("File is readable: " + file.getName());
                        }
                    } else {
                        System.out.println("Found subdirectory: " + fileName);
                    }
                }
            } else {
                System.out.println("Entered path is not a directory.");
            }
        } else {
            System.out.println("Entered path does not exist.");
        }

        scanner.close();
    }
}