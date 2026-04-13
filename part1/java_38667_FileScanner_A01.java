import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;

public class java_38667_FileScanner_A01 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        String extension = "txt";

        secureFileSearch(directoryPath, extension);
    }

    public static void secureFileSearch(String directoryPath, String extension) {
        File directory = new File(directoryPath);

        File[] files = directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(extension.toLowerCase());
            }
        });

        if (files != null) {
            for (File file : files) {
                try {
                    System.out.println("Found file: " + file.getAbsolutePath());

                    // Perform security-sensitive operations here
                    // ...

                } catch (FileNotFoundException e) {
                    System.out.println("File not found: " + file.getAbsolutePath());
                }
            }
        } else {
            System.out.println("No files found in directory");
        }
    }
}