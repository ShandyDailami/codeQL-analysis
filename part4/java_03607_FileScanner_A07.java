import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_03607_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter file extension to search:");
        String fileExtension = scanner.nextLine();

        try {
            File directory = new File(directoryPath);

            if (directory.exists()) {
                File[] files = directory.listFiles(new FileFilter() {
                    @Override
                    public boolean accept(File pathname) {
                        return pathname.isFile() && pathname.getName().endsWith(fileExtension);
                    }
                });

                if (files != null) {
                    Arrays.stream(files).forEach(file -> System.out.println(file.getAbsolutePath()));
                } else {
                    System.out.println("No files found with extension " + fileExtension + " in directory " + directoryPath);
                }

            } else {
                System.out.println("Directory does not exist.");
            }

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}