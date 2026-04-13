import java.io.File;
import java.util.Scanner;

public class java_12125_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.next();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    String fileName = file.getName();
                    if (fileName.endsWith(".properties") || fileName.endsWith(".json")) {
                        scanFile(file);
                    }
                }
            }
        }

        scanner.close();
    }

    private static void scanFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("username") || line.contains("password")) {
                    System.out.println("Potential authentication failure detected in file: " + file.getPath());
                    // Add more secure operations related to authentication failure here
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred while scanning the file: " + file.getPath());
        }
    }
}