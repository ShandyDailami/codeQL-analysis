import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class java_38565_FileScanner_A08 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File startingDirectory = new File(dirPath);
        if (!startingDirectory.exists()) {
            System.out.println("Invalid directory path!");
            return;
        }

        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.isFile()) {
                    return false;
                }
                return true;
            }
        };

        System.out.println("Searching for files in: " + startingDirectory.getPath());
        findFiles(startingDirectory, fileFilter);
    }

    private static void findFiles(File dir, FileFilter filter) throws IOException {
        File[] listFiles = dir.listFiles(filter);
        if (listFiles == null) {
            return;
        }

        for (File file : listFiles) {
            if (file.isFile()) {
                System.out.println("File found: " + file.getPath());
            } else {
                findFiles(file, filter);
            }
        }
    }
}