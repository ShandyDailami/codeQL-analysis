import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_41702_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/your/directory";  // replace with your directory path
        String extension = ".txt";  // replace with your extension

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(extension));

            if (txtFiles != null) {
                for (File txtFile : txtFiles) {
                    try (Scanner scanner = new Scanner(txtFile)) {
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            System.out.println(line);
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("Failed to open file: " + txtFile.getName());
                    }
                }
            } else {
                System.out.println("No files with extension: " + extension);
            }
        } else {
            System.out.println("Directory does not exist or is not a directory: " + directoryPath);
        }
    }
}