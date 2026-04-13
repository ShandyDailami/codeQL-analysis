import java.io.File;
import java.util.Scanner;

public class java_12617_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for directory path
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.next();

        // Prompt user for file extension
        System.out.print("Enter the file extension: ");
        String fileExtension = scanner.next();

        File directory = new File(directoryPath);

        // Use the `listFiles()` method of `File` to get a File array of files in the directory
        File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

        // Use a for-each loop to iterate over the file array and print each file's name and size
        for (File file : files) {
            System.out.println("File name: " + file.getName());
            System.out.println("File size: " + file.length() + " bytes");
        }
    }
}