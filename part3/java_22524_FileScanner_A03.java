import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_22524_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with actual directory path
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && isFileSecure(file)) {
                        try (Scanner scanner = new Scanner(file)) {
                            while (scanner.hasNextLine()) {
                                String line = scanner.nextLine();
                                // process line here
                            }
                        } catch (FileNotFoundException e) {
                            System.out.println("File not found: " + file.getAbsolutePath());
                        }
                    }
                }
            } else {
                System.out.println("No files in directory: " + directoryPath);
            }
        } else {
            System.out.println("Invalid directory path: " + directoryPath);
        }
    }

    private static boolean isFileSecure(File file) {
        // Add your security-sensitive operations here
        // For now, let's just return true to simulate a secure file
        return true;
    }
}