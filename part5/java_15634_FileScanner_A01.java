import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_15634_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            searchFile(directory, ".txt");
        } else {
            System.out.println("Directory does not exist or it is not a directory.");
        }
    }

    private static void searchFile(File directory, String extension) {
        File[] files = directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(extension);
            }
        });

        if (files != null) {
            Arrays.stream(files).forEach(FileScanner::printFileDetails);
        }

        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                searchFile(file, extension);
            }
        }
    }

    private static void printFileDetails(File file) {
        System.out.println("File Name: " + file.getName());
        System.out.println("File Path: " + file.getAbsolutePath());
        System.out.println("File Size: " + file.length() + " bytes");
    }
}