import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_07255_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // Replace with your directory path
        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] allFiles = directory.listFiles();

            if (allFiles != null) {
                for (File file : allFiles) {
                    if (file.isFile()) {
                        try {
                            Scanner scanner = new Scanner(file);
                            while (scanner.hasNextLine()) {
                                String line = scanner.nextLine();
                                // Security-sensitive operation: Check file permissions
                                if (!file.canRead()) {
                                    System.out.println("Broken access to file: " + file.getAbsolutePath());
                                }
                            }
                            scanner.close();
                        } catch (FileNotFoundException e) {
                            System.out.println("File not found: " + file.getAbsolutePath());
                        }
                    }
                }
            }
        } else {
            System.out.println("Directory not found: " + directoryPath);
        }
    }
}