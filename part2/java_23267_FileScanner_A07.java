import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class java_23267_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();

        File startingDirectory = new File(directoryPath);

        String[] extensions = new String[]{"java"};

        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return true;
            }
        };

        scanFiles(startingDirectory, filter, extensions);
    }

    private static void scanFiles(File dir, FilenameFilter filter, String[] extensions) {
        File[] files = dir.listFiles(filter);

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanFiles(file, filter, extensions);
                } else {
                    for (String extension : extensions) {
                        if (file.getName().endsWith(extension)) {
                            System.out.println("File: " + file.getAbsolutePath());
                        }
                    }
                }
            }
        }
    }
}