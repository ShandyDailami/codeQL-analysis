import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_24227_FileScanner_A08 {
    public static void main(String[] args) {
        String dirPath = "/path/to/directory"; // replace with your directory path
        File dir = new File(dirPath);

        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Invalid directory path");
            return;
        }

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a keyword to search for in file names:");
            String keyword = scanner.nextLine();

            System.out.println("Searching for files with keyword '" + keyword + "'");
            File[] foundFiles = dir.listFiles((dir1, name) -> name.endsWith(".txt"));

            if (foundFiles != null) {
                for (File file : foundFiles) {
                    if (file.getName().contains(keyword)) {
                        System.out.println(file.getName());
                    }
                }
            } else {
                System.out.println("No .txt files found in directory");
            }

            System.out.println("File scanning finished");
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}