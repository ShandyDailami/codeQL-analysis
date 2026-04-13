import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class java_41448_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String dirPath = scanner.nextLine();

        System.out.println("Enter file extension to search for (e.g. '.txt'):");
        String fileExtension = scanner.nextLine();

        // Create the File object for the directory
        File dir = new File(dirPath);

        // Create a FileFilter that only accepts directories
        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return new File(dir, name).isDirectory();
            }
        };

        // Use the File object and its FilenameFilter to search the directory
        File[] dirContents = dir.listFiles(filter);

        if (dirContents != null) {
            for (File file : dirContents) {
                if (file.getName().endsWith(fileExtension)) {
                    System.out.println("File found: " + file.getAbsolutePath());
                }
            }
        } else {
            System.out.println("Directory not found.");
        }
    }
}