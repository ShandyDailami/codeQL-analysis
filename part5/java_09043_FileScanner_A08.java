import java.io.File;
import java.io.FilenameFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_09043_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        System.out.println("Enter the file extension to search for:");
        String ext = scanner.nextLine();

        File dir = new File(dirPath);
        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(ext);
            }
        };

        printFiles(dir, filter);
    }

    private static void printFiles(File dir, FilenameFilter filter) {
        File[] files = dir.listFiles(filter);
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                    printFiles(file, filter);
                }
            }
        }
    }
}