import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class java_31828_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        System.out.println("Enter the file names to exclude (comma-separated):");
        String[] exclusionList = scanner.nextLine().split(",");

        File directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory path!");
            System.exit(0);
        }

        List<String> exclusionList = Arrays.asList(exclusionList);
        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("No files found in the directory!");
            System.exit(0);
        }

        for (File file : files) {
            if (file.isFile() && !exclusionList.contains(file.getName())) {
                System.out.println("Found file: " + file.getAbsolutePath());
            } else if (file.isDirectory()) {
                System.out.println("Found directory: " + file.getAbsolutePath());
            }
        }

        scanner.close();
    }
}