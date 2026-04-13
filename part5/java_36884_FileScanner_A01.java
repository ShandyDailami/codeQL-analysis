import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class java_36884_FileScanner_A01 {
    public static void main(String[] args) throws IOException {
        String directoryPath = "/path/to/directory"; // Replace with your directory path
        String extension = ".*\\.txt$"; // Replace with your extension

        File directory = new File(directoryPath);

        File[] files = directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.matches(extension);
            }
        });

        if (files != null) {
            for (File file : files) {
                System.out.println(file.getPath());
            }
        }
    }
}