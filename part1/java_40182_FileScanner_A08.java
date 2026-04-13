import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class java_40182_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        String fileExtension = ".txt"; // replace with your file extension

        File directory = new File(directoryPath);

        File[] files = directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(fileExtension);
            }
        });

        if (files != null) {
            Arrays.stream(files).forEach(file -> System.out.println("File: " + file.getPath()));
        } else {
            System.out.println("No files found with the extension: " + fileExtension);
        }
    }
}