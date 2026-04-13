import java.io.File;
import java.util.Arrays;

public class java_30414_FileScanner_A03 {
    public static void main(String[] args) {
        // Change this to your directory
        String directoryPath = "/path/to/directory";
        File directory = new File(directoryPath);

        File[] files = directory.listFiles();

        if (files != null) {
            Arrays.stream(files).forEach(file -> {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                }
            });
        } else {
            System.out.println("No files found in the directory.");
        }
    }
}