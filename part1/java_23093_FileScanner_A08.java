import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_23093_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        // Get the directory to scan from user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();

        // Create a FileFilter that only matches .txt files
        FileFilter textFilesFilter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        };

        // Use File's list method with the filter to get all text files
        File directory = new File(directoryPath);
        File[] textFiles = directory.listFiles(textFilesFilter);

        // Print out the names of the text files
        for (File file : textFiles) {
            System.out.println(file.getName());
        }
    }
}