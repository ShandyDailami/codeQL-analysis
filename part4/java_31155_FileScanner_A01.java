import java.io.File;
import java.util.Arrays;

public class java_31155_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // replace with your directory path
        String fileExtension = ".*";  // replace with your file extension

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

            if (files != null) {
                Arrays.stream(files)
                        .filter(file -> file.isFile() && file.canRead())
                        .forEach(file -> System.out.println("File name: " + file.getName()));
            } else {
                System.out.println("No files found with the specified extension.");
            }
        } else {
            System.out.println("Invalid directory or directory does not exist.");
        }
    }
}