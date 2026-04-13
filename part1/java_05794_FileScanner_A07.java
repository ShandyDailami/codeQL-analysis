import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_05794_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File("src/main/resources");
        scanDirectory(file);
    }

    private static void scanDirectory(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file);
                } else {
                    if (file.getName().endsWith(".txt")) {
                        scanFile(file);
                    }
                }
            }
        }
    }

    private static void scanFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("authFailure")) {
                    System.out.println("Found authFailure in: " + file.getAbsolutePath());
                    // You can add the code here to handle the authFailure exception
                }
            }
        } catch (Exception e) {
            System.out.println("Error occurred while scanning file: " + file.getAbsolutePath());
        }
    }
}