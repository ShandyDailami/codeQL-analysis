import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class java_01945_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter directory path:");
        String dirPath = scanner.nextLine();

        System.out.println("Enter file extension:");
        String fileExtension = scanner.nextLine();

        File dir = new File(dirPath);

        FileFilter fileFilter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().toLowerCase().endsWith(fileExtension);
            }
        };

        System.out.println("Scanning directory: " + dir.getAbsolutePath());

        File[] files = dir.listFiles(fileFilter);

        if (files == null) {
            System.out.println("No files found with extension " + fileExtension);
        } else {
            System.out.println("Found the following files: " + Arrays.toString(files));
        }

        scanner.close();
    }
}