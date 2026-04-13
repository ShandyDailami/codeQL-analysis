import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_28469_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String path = scanner.next();
        scanner.close();

        File directory = new File(path);

        if (!directory.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        if (!directory.isDirectory()) {
            System.out.println("Input is not a directory.");
            return;
        }

        String[] files = directory.list();
        if (files == null) {
            System.out.println("No files or directories in the directory.");
            return;
        }

        System.out.println("Files in directory: " + Arrays.toString(files));

        System.out.print("Enter file extension to filter: ");
        String extension = scanner.next();
        scanner.close();

        final FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith("." + extension);
            }
        };

        files = directory.list(filter);
        if (files == null) {
            System.out.println("No files with the specified extension in the directory.");
            return;
        }

        System.out.println("Files with extension " + extension + ": " + Arrays.toString(files));
    }
}