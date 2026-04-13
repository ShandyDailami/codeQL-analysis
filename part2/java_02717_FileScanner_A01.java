import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_02717_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String path = scanner.nextLine();
        System.out.println("Enter file extension (e.g. .txt):");
        String extension = scanner.nextLine();

        File directory = new File(path);

        FileFilter filter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(extension);
            }
        };

        File[] files = directory.listFiles(filter);

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File found: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("Directory found: " + file.getName());
                }
            }
        } else {
            System.out.println("No files found in the specified directory.");
        }
    }
}