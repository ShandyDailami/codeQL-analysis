import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_12225_FileScanner_A03 {

    public static void main(String[] args) {

        // Create a new scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the directory
        System.out.println("Enter the directory: ");
        String directory = scanner.nextLine();

        // Create a new File object
        File file = new File(directory);

        // Create a new FileFilter for the directory
        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt");
            }
        };

        // Use the listFiles method of the file object to get a list of all .txt files
        File[] txtFiles = file.listFiles(filter);

        // Print the list of .txt files
        System.out.println("The .txt files in the directory are: " + Arrays.toString(txtFiles));
    }
}