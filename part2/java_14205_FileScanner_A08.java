import java.io.File;
import java.util.Scanner;

public class java_14205_FileScanner_A08 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the file name pattern (e.g., *.txt):");
        String fileNamePattern = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] matchingFiles = directory.listFiles((dir, name) -> name.matches(fileNamePattern));

        if (matchingFiles != null) {
            for (File file : matchingFiles) {
                if (file.isFile()) {
                    System.out.println("Found file: " + file.getAbsolutePath());
                }
            }
        } else {
            System.out.println("No matching files found in directory.");
        }

        scanner.close();
    }
}