import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_16587_FileScanner_A03 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);

        // Verify if the directory exists and is accessible
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        // Read the file line by line
                        try (Scanner scanner = new Scanner(file)) {
                            while (scanner.hasNextLine()) {
                                String line = scanner.nextLine();
                                // Process the line (e.g., print the line)
                                System.out.println(line);
                            }
                        } catch (FileNotFoundException e) {
                            System.out.println("Error reading file: " + file.getAbsolutePath());
                        }
                    }
                }
            } else {
                System.out.println("No files in directory: " + directory.getAbsolutePath());
            }
        } else {
            System.out.println("Directory does not exist or is not accessible: " + directory.getAbsolutePath());
        }
    }
}