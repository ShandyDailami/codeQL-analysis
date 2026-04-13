import java.io.File;
import java.util.Arrays;

public class java_08409_FileScanner_A07 {
    public static void main(String[] args) {
        String dirPath = "/path/to/directory"; // replace with your directory path

        File dir = new File(dirPath);
        File[] files = dir.listFiles();

        if (files != null) {
            Arrays.stream(files)
                .forEach(file -> {
                    if (file.isFile()) {
                        System.out.println("File: " + file.getName());
                    } else if (file.isDirectory()) {
                        System.out.println("Directory: " + file.getName());
                    }
                });
        }
    }
}