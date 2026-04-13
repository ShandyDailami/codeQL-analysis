import java.io.File;
import java.util.Scanner;

public class java_13556_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            checkDirectoryForIntegrityFailure(directory);
        } else {
            System.out.println("Directory does not exist.");
        }
    }

    private static void checkDirectoryForIntegrityFailure(File directory) {
        File[] listOfFiles = directory.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.getName().contains("integrity")) {
                    System.out.println("Integrity failure detected in: " + file.getAbsolutePath());
                } else {
                    System.out.println("No integrity failures detected in: " + file.getAbsolutePath());
                }
            }
        }
    }
}