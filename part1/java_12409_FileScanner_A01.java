import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_12409_FileScanner_A01 {
    private static final String DIRECTORY_PATH = "/path/to/directory"; // replace with your directory path

    public static void main(String[] args) {
        File directory = new File(DIRECTORY_PATH);

        // Ensure the directory exists and is accessible
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Directory does not exist or is not a directory");
            return;
        }

        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            System.out.println(line);
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found: " + file.getAbsolutePath());
                    }
                }
            }
        }
    }
}