import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Scanner;

public class java_04701_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.next();

        System.out.println("Enter the file extension (example: .txt):");
        String extension = scanner.next();

        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            fileInDir(dir, extension);
        } else {
            System.out.println("Directory not found!");
        }

        scanner.close();
    }

    private static void fileInDir(File dir, String extension) {
        File[] files = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(extension);
            }
        });

        if (files != null) {
            for (File file : files) {
                printFileDetails(file);
            }
        }
    }

    private static void printFileDetails(File file) {
        System.out.println("File Name: " + file.getName());
        System.out.println("File Path: " + file.getPath());
        System.out.println("File Size: " + file.length() + " bytes");
        System.out.println("----------------------");
    }
}