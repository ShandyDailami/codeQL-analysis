import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_32421_FileScanner_A08 {
    public static void main(String[] args) {
        // Ask user for directory and extension
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory: ");
        String directory = scanner.nextLine();
        System.out.print("Enter extension: ");
        String extension = scanner.nextLine();

        // Create File object for directory
        File dir = new File(directory);

        // Create FilenameFilter to find files with specified extension
        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith("." + extension);
            }
        };

        // Find files in directory and print their names
        File[] files = dir.listFiles(filter);
        if (files == null) {
            System.out.println("No files with the specified extension found in the directory.");
        } else {
            Arrays.sort(files, String.CASE_INSENSITIVE_ORDER);
            for (File file : files) {
                System.out.println(file.getName());
            }
        }

        // Close scanner
        scanner.close();
    }
}