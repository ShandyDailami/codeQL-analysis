import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_37564_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        };

        System.out.println("Listing text files in " + directory.getAbsolutePath() + ":");
        findFiles(directory, filter);

        FilenameFilter filenameFilter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt");
            }
        };

        System.out.println("\nListing text files in " + directory.getAbsolutePath() + " using FilenameFilter:");
        findFiles(directory, filenameFilter);

        scanner.close();
    }

    private static void findFiles(File directory, FileFilter filter) throws FileNotFoundException {
        if (directory.listFiles(filter).length == 0) {
            System.out.println("No text files found!");
        } else {
            for (File file : directory.listFiles(filter)) {
                System.out.println(file.getAbsolutePath());
            }
        }
    }
}