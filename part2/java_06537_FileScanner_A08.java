import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_06537_FileScanner_A08 {
    private static final String DIR_PATH = "src/main/java/";

    public static void main(String[] args) {
        File dir = new File(DIR_PATH);
        checkDirIntegrity(dir);
    }

    private static void checkDirIntegrity(File dir) {
        if (!dir.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }
        if (!dir.canRead()) {
            System.out.println("Directory does not have read permissions.");
            return;
        }

        File[] files = dir.listFiles();
        if (files == null) {
            System.out.println("Error occurred while accessing the directory.");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                checkFileIntegrity(file);
            } else if (file.isDirectory()) {
                checkDirIntegrity(file);
            }
        }
    }

    private static void checkFileIntegrity(File file) {
        if (!file.exists()) {
            System.out.println("File does not exist.");
            return;
        }
        if (!file.canRead()) {
            System.out.println("File does not have read permissions.");
            return;
        }
        if (file.length() <= 0) {
            System.out.println("File is empty.");
            return;
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Check for security sensitive operations here.
                // For now, we just print the line.
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error occurred while accessing the file.");
        }
    }
}