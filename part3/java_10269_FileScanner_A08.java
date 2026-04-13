import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_10269_FileScanner_A08 {
    private static final String DIRECTORY_PATH = "your_directory_path";
    private static final String EXTENSION = "your_extension";

    public static void main(String[] args) {
        File directory = new File(DIRECTORY_PATH);

        if (directory.exists()) {
            File[] files = directory.listFiles((dir, name) -> name.endsWith(EXTENSION));

            if (files != null) {
                Arrays.stream(files)
                        .filter(file -> file.canRead() && !file.isHidden())
                        .forEach(file -> System.out.println(file.getName()));
            }
        } else {
            System.out.println("Directory does not exist");
        }
    }
}