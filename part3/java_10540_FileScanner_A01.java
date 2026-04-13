import java.io.File;
import java.util.Scanner;

public class java_10540_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the directory path: ");
        String directoryPath = scanner.nextLine();

        // Create a File object for the directory
        File directory = new File(directoryPath);

        // List all files in the directory
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    // Print the name of the file
                    System.out.println("File name: " + file.getName());
                }
            }
        } else {
            System.out.println("The directory does not exist.");
        }
    }
}