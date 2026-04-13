import java.io.File;
import java.util.Arrays;

public class java_33786_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                Arrays.stream(files).forEach(file -> {
                    if (file.isFile()) {
                        System.out.println(file.getName());
                    }
                });
            } else {
                System.out.println("No files found in the directory!");
            }
        } else {
            System.out.println("Directory not found!");
        }
    }
}