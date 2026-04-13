import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class java_36058_FileScanner_A08 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/your/directory";

        File directory = new File(directoryPath);

        FilenameFilter filter = (dir, name) -> {
            File file = new File(dir, name);
            return file.isFile() && !file.getName().startsWith(".");
        };

        File[] files = directory.listFiles(filter);

        if (files != null) {
            Arrays.stream(files).forEach(file -> System.out.println(file.getAbsolutePath()));
        } else {
            System.out.println("No files found in the directory.");
        }
    }
}