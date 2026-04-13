import java.io.File;
import java.io.FilenameFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_01966_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a scanner for user input
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter directory path: ");
        String path = scanner.next();

        // Use recursive method to search for files in directory
        recursiveSearch(path);

        scanner.close();
    }

    private static void recursiveSearch(String path) throws FileNotFoundException {
        File file = new File(path);
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    // This method filters files for A07_AuthFailure
                    return name.endsWith(".txt");
                }
            });

            // Check each file in directory
            for (File f : listFiles) {
                if (f.isFile()) {
                    // Print file path
                    System.out.println("File path: " + f.getAbsolutePath());
                } else {
                    // Recursive call
                    recursiveSearch(f.getAbsolutePath());
                }
            }
        }
    }
}