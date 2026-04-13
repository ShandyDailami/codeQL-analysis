import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class java_08288_FileScanner_A03 {
    private static Set<String> readFiles = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);
        if (directory.exists() && directory.isDirectory()) {
            searchTextFiles(directory);
        } else {
            System.out.println("Invalid directory path");
        }
    }

    private static void searchTextFiles(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    if (readFiles.contains(file.getName())) {
                        System.out.println("File " + file.getName() + " has already been read");
                    } else {
                        readFiles.add(file.getName());
                        System.out.println("Processing file: " + file.getName());
                        // Process the file here
                    }
                }
            }
        }
    }
}