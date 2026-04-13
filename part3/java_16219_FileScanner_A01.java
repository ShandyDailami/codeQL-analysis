import java.io.File;
import java.util.Arrays;

public class java_16219_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // replace this with your directory path

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                Arrays.stream(files)
                      .forEach(file -> System.out.println(file.getName()));
            }
        } else {
            System.out.println("Directory not found!");
        }
    }
}