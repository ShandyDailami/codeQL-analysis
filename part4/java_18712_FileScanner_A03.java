import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_18712_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String path = scanner.nextLine();

        File directory = new File(path);

        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Scanning files in " + directory.getAbsolutePath());
            scanDirectory(directory, "");
        } else {
            System.out.println("Invalid directory path");
        }
    }

    private static void scanDirectory(File directory, String path) {
        File[] listFiles = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getAbsolutePath().endsWith(".txt");
            }
        });

        if (listFiles != null) {
            Arrays.stream(listFiles).forEach(file -> scanFile(file.getAbsolutePath()));
        }

        File[] subDirectories = directory.listFiles(File::isDirectory);
        if (subDirectories != null) {
            Arrays.stream(subDirectories).forEach(dir -> scanDirectory(dir, path + "/" + dir.getName()));
        }
    }

    private static void scanFile(String filePath) {
        File file = new File(filePath);
        if (file.exists() && file.isFile()) {
            System.out.println("Found file: " + file.getAbsolutePath());
        }
    }
}