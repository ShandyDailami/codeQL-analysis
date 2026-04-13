import java.io.File;
import java.util.Scanner;

public class java_35532_FileScanner_A03 {

    public static void main(String[] args) {

        // Get the path from the user
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        // Create a File object
        File file = new File(path);

        // Check if the path is valid
        if (file.exists()) {
            printFileContent(file);
        } else {
            System.out.println("The path does not exist.");
        }

        scanner.close();
    }

    private static void printFileContent(File file) {
        // Check if the file is a directory
        if (file.isDirectory()) {
            System.out.println("The path is a directory: " + file.getAbsolutePath());
            String[] children = file.list();
            // Iterate over the children
            for (String child : children) {
                File childFile = new File(file, child);
                printFileContent(childFile);
            }
        } else {
            // Check if the file is a regular file
            if (file.isFile()) {
                System.out.println("The path is a file: " + file.getAbsolutePath());
                printFileContents(file);
            }
        }
    }

    private static void printFileContents(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + file.getAbsolutePath());
        }
    }
}