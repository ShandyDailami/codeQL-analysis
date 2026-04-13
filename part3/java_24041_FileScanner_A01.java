import java.io.File;
import java.util.Scanner;
import java.util.regex.Pattern;

public class java_24041_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.next();
        System.out.println("Enter the file extension to search:");
        String fileExtension = scanner.next();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Searching for files with extension: " + fileExtension);

            File[] files = directory.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    return pathname.isFile() && pathname.getName().endsWith(fileExtension);
                }
            });

            if (files != null) {
                for (File file : files) {
                    System.out.println("Found file: " + file.getAbsolutePath());
                }
            } else {
                System.out.println("No files found with extension: " + fileExtension);
            }
        } else {
            System.out.println("The directory does not exist or is not a directory.");
        }

        scanner.close();
    }
}