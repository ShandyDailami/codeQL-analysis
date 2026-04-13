import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_28733_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory:");
        String directory = scanner.nextLine();

        File rootDirectory = new File(directory);

        // Create a filter to only include files in the root directory
        FilenameFilter filter = (dir, name) -> {
            File file = new File(dir, name);
            return file.isFile();
        };

        printFilesInDirectory(rootDirectory, filter);
    }

    private static void printFilesInDirectory(File dir, FilenameFilter filter) {
        File[] files = dir.listFiles(filter);
        if (files != null) {
            Arrays.stream(files).forEach(FileScanner::printFileDetails);
        }
    }

    private static void printFileDetails(File file) {
        System.out.println("File: " + file.getAbsolutePath());
    }
}