import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_17529_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        // Creating a scanner to read the input
        Scanner scanner = new Scanner(System.in);

        // Prompting user for input
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        System.out.println("Enter the file extension:");
        String extension = scanner.nextLine();

        // Creating a File object with the input path
        File directory = new File(path);

        // Using a FileFilter to find all files with the given extension
        File[] files = directory.listFiles((dir, name) -> name.endsWith(extension));

        if (files == null) {
            System.out.println("No files with that extension found in the directory.");
        } else {
            System.out.println("Files with extension " + extension + " found in the directory:");
            for (File file : files) {
                System.out.println(file.getName());
            }
        }

        scanner.close();
    }
}