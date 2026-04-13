import java.io.File;
import java.util.Scanner;

public class java_12776_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        try {
            File file = new File(directoryPath);
            File[] hiddenFiles = file.listFiles(file -> file.isHidden());

            for (File hiddenFile : hiddenFiles) {
                if (hiddenFile.getName().endsWith(".tmp")) {
                    System.out.println("Found a hidden temporary file: " + hiddenFile.getName());
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }

        scanner.close();
    }
}