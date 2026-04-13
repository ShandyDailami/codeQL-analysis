import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_29335_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "path/to/directory";
        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] allFiles = directory.listFiles();
            if (allFiles != null) {
                for (File file : allFiles) {
                    if (file.isFile()) {
                        try (Scanner scanner = new Scanner(file)) {
                            while (scanner.hasNextLine()) {
                                String line = scanner.nextLine();
                                // Here you can implement security-sensitive operations related to file integrity failures
                                // This example simply prints the line
                                System.out.println(line);
                            }
                        } catch (FileNotFoundException e) {
                            System.out.println("File not found: " + file.getPath());
                        }
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist: " + directoryPath);
        }
    }
}