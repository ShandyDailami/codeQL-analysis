import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_34338_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        FileFilter filter = new FileFilter() {
            public boolean accept(File pathname) {
                // This filter will only accept directories
                return pathname.isDirectory();
            }
        };

        printFilesInDirectory(directory, filter);
    }

    private static void printFilesInDirectory(File directory, FileFilter filter) {
        File[] files = directory.listFiles(filter);

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    printFile(file);
                } else {
                    printFilesInDirectory(file, filter);
                }
            }
        }
    }

    private static void printFile(File file) {
        System.out.println(file.getName());
    }
}