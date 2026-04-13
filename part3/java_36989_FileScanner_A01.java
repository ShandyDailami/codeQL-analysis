import java.io.File;
import java.io.FilenameFilter;

public class java_36989_FileScanner_A01 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        String fileExtension = ".*\\.txt$"; // replace with your file extension

        File directory = new File(directoryPath);
        File[] files = directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.matches(fileExtension);
            }
        });

        if (files != null) {
            for (File file : files) {
                processFile(file);
            }
        }
    }

    private static void processFile(File file) {
        // implement security-sensitive operations here
        // for example, access control
        // ...

        System.out.println("Processed: " + file.getAbsolutePath());
    }
}