import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class java_24964_FileScanner_A03 {
    private static final List<String> VALID_EXTENSIONS = Arrays.asList(".txt", ".doc", ".pdf", ".xlsx", ".csv");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] listOfFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.canRead()) {
                    System.out.println("Found a file: " + file.getName());
                } else {
                    System.out.println("File " + file.getName() + " is not readable.");
                }
            }
        } else {
            System.out.println("Unable to list files in " + directoryPath);
        }

        scanner.close();
    }
}