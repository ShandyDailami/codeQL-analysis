import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_12254_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        System.out.println("Searching for files in " + directory.getAbsolutePath());

        findFiles(directory, (dir, name) -> name.endsWith(".txt"));
    }

    private static void findFiles(File directory, FilenameFilter filter) {
        if (directory.listFiles(filter).length == 0) {
            System.out.println("No files found.");
        } else {
            System.out.println("Files found: " + Arrays.toString(directory.listFiles(filter)));
        }
    }
}