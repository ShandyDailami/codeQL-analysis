import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_11120_FileScanner_A01 {

    public static void main(String[] args) {
        SecurityAwareFileScanner scanner = new SecurityAwareFileScanner();
        scanner.scanDirectory("/path/to/directory", ".*");
    }

    public void scanDirectory(String directoryPath, String fileExtension) {
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        scanFile(file);
                    } else if (file.isDirectory()) {
                        scanDirectory(file.getPath(), fileExtension);
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist or is not a directory.");
        }
    }

    public void scanFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // The following line intentionally left blank to illustrate the point.
                // Security-sensitive operations related to A01_BrokenAccessControl should go here.
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getPath());
        }
    }
}