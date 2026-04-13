import java.io.File;
import java.util.Scanner;

public class java_31170_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path of the directory:");
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);

        System.out.println("Enter the name of the file:");
        String fileName = scanner.nextLine();

        File file = new File(directory, fileName);

        // Security-sensitive operation (A08_IntegrityFailure)
        try {
            File[] hiddenFiles = file.getParentFile().listFiles(file -> file.isHidden());
            if (hiddenFiles != null) {
                for (File hiddenFile : hiddenFiles) {
                    System.out.println("Found hidden file: " + hiddenFile.getName());
                }
            }
        } catch (SecurityException e) {
            System.out.println("Access denied: " + e.getMessage());
        }

        scanner.close();
    }
}