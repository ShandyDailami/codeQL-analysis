import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_34837_FileScanner_A01 {
    public static void main(String[] args) {
        // Remove the comment to proceed with code
    }

    public static void scanFiles(String directoryPath) {
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        if (!directory.canRead()) {
            System.out.println("You do not have permission to read this directory");
            return;
        }

        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            System.out.println("File: " + file.getName() + ", Line: " + line);
                        }
                        scanner.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("Unable to read file: " + file.getName());
                    }
                } else if (file.isDirectory()) {
                    scanFiles(file.getPath());
                }
            }
        }
    }
}