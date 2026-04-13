import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_20377_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with actual directory path
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        File[] files = directory.listFiles();

        if (files == null) {
            System.out.println("No files found in directory");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        if (line.contains("IntegrityFailure")) {
                            System.out.println("Found file with 'IntegrityFailure': " + file.getAbsolutePath());
                        }
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("Error reading file: " + file.getAbsolutePath());
                }
            }
        }
    }
}