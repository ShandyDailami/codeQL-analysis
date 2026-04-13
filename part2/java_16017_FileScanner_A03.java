import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_16017_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();

        File startingDirectory = new File(directoryPath);

        FileFilter filter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile();
            }
        };

        listFilesRecursively(startingDirectory, filter);
    }

    private static void listFilesRecursively(File startingDirectory, FileFilter filter) {
        File[] files = startingDirectory.listFiles(filter);
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    listFilesRecursively(file, filter);
                } else {
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }
}