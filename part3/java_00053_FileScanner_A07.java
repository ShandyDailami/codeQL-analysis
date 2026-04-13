import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class java_00053_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.next();

        File dir = new File(dirPath);

        if (!dir.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        if (!dir.isDirectory()) {
            System.out.println("Given path is not a directory.");
            return;
        }

        System.out.println("Scanning files in directory: " + dir.getAbsolutePath());
        scanDirectory(dir);
    }

    private static void scanDirectory(File dir) {
        File[] files = dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return new File(dir, name).isFile();
            }
        });

        if (files != null) {
            for (File file : files) {
                System.out.println(file.getName());
            }
        }

        File[] subDirs = dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return new File(dir, name).isDirectory();
            }
        });

        if (subDirs != null) {
            for (File subDir : subDirs) {
                scanDirectory(subDir);
            }
        }
    }
}