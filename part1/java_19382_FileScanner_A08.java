import java.io.File;
import java.util.Scanner;

public class java_19382_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the string to search:");
        String searchString = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] directoryContents = directory.listFiles();

        if (directoryContents != null) {
            for (File file : directoryContents) {
                if (file.isFile()) {
                    if (searchForStringInFile(file, searchString)) {
                        System.out.println("String found in file: " + file.getName());
                    }
                } else {
                    System.out.println("Skipping directory: " + file.getName());
                }
            }
        } else {
            System.out.println("No files or directories found in the directory.");
        }

        scanner.close();
    }

    private static boolean searchForStringInFile(File file, String searchString) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(searchString)) {
                    return true;
                }
            }
        } catch (Exception e) {
            // Handle exception properly in a production-level code
            System.out.println("An error occurred while reading the file: " + file.getName());
        }
        return false;
    }
}