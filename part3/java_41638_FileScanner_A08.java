import java.io.File;
import java.util.Scanner;

public class java_41638_FileScanner_A08 {
    public static void main(String[] args) {
        // Define the directory path
        String directoryPath = "/path/to/your/directory";

        // Create a File object for the directory
        File directory = new File(directoryPath);

        // Create a FileFilter to filter out non-text files
        FileFilter textFileFilter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().toLowerCase().endsWith(".txt");
            }
        };

        // Use the listFiles method of File to get all text files in the directory
        File[] textFiles = directory.listFiles(textFileFilter);

        // Create a Scanner to read the names of the text files
        Scanner scanner = new Scanner(System.in);

        // Ask the user to enter a pattern
        System.out.println("Enter a pattern to search for:");
        String pattern = scanner.nextLine();

        // Print out the names of the text files that match the user's pattern
        for (File file : textFiles) {
            if (file.getName().contains(pattern)) {
                System.out.println(file.getName());
            }
        }

        // Close the scanner
        scanner.close();
    }
}