import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_28481_FileScanner_A03 {

    public static void main(String[] args) {
        SecurityScanner scanner = new SecurityScanner();
        scanner.scanDirectory("/path/to/directory");
    }

    public void scanDirectory(String directoryPath) {
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        File[] files = directory.listFiles();

        if (files == null) {
            System.out.println("Unable to list files!");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                scanFile(file);
            } else if (file.isDirectory()) {
                scanDirectory(file.getPath());
            }
        }
    }

    private void scanFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // This is a placeholder for security-sensitive operation.
                // In a real application, you should replace this with a real security-sensitive operation.
                // For example, you might scan for a specific string, or attempt to execute a command or operation based on the line.
                if (line.contains("sensitive")) {
                    System.out.println("Detected sensitive line in file: " + file.getPath());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file: " + file.getPath());
        }
    }
}