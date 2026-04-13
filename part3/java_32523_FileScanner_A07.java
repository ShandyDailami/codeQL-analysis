import java.io.File;
import java.util.Scanner;

public class java_32523_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file extension: ");
        String extension = scanner.next();

        File directory = new File(".");

        System.out.println("\nFiles with " + extension + " extension:");
        scanFiles(directory, extension);
    }

    private static void scanFiles(File directory, String extension) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(extension)) {
                    System.out.println(file.getName());
                } else if (file.isDirectory()) {
                    scanFiles(file, extension);
                }
            }
        }
    }
}