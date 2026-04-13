import java.io.File;
import java.util.Scanner;

public class java_33109_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);
        File[] listOfFiles = directory.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    System.out.println("File: " + file.getName());
                    authFailureScan(file);
                }
            }
        }
    }

    private static void authFailureScan(File file) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("authFailure")) {
                    System.out.println("Auth Failure detected in file: " + file.getName());
                    // Here you can implement the security-sensitive operations related to auth failure
                }
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error reading file: " + file.getName());
        }
    }
}