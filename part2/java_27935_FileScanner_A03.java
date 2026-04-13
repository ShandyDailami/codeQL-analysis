import java.io.File;
import java.util.Scanner;

public class java_27935_FileScanner_A03 {

    private static final String INPUT_DIRECTORY = "src";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);
        if (!directory.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        if (!directory.isDirectory()) {
            System.out.println("Entered path is not a directory!");
            return;
        }

        fileScanner(directory);
    }

    private static void fileScanner(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    if (isSensitiveOperation(file)) {
                        System.out.println("Sensitive operation performed on file: " + file.getName());
                    }
                } else if (file.isDirectory()) {
                    fileScanner(file);
                }
            }
        }
    }

    private static boolean isSensitiveOperation(File file) {
        // Implement the security-sensitive operation here
        // Return true if the operation is successful, false otherwise
        return true;
    }
}