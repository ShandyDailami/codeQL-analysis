import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Scanner;

public class java_29990_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the search string:");
        String searchString = scanner.nextLine();

        File directory = new File(directoryPath);

        // Using anonymous inner class for FileFilter
        File[] files = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                // Check if the file is a directory
                if (pathname.isDirectory()) {
                    return true;
                }
                // Check if the file name contains the search string
                return pathname.getName().contains(searchString);
            }
        });

        // Checking if files are null, to avoid null pointer exception
        if (files != null) {
            for (File file : files) {
                System.out.println(file.getAbsolutePath());
            }
        } else {
            System.out.println("No files found.");
        }

        scanner.close();
    }
}