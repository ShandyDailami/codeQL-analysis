import java.io.File;
import java.util.Scanner;

public class java_31785_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        System.out.println("Enter the command to execute:");
        String command = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        // Command injection example
                        // We're assuming that the user is executing a command and we're just displaying the file content
                        // This is not real security, it's a simple example
                        String fileContent = command + " " + file.getAbsolutePath();
                        System.out.println("File content: " + fileContent);
                    }
                }
            } else {
                System.out.println("No files found in the directory.");
            }
        } else {
            System.out.println("The provided path is not a directory.");
        }

        scanner.close();
    }
}