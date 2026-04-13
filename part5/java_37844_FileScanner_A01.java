import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class java_37844_FileScanner_A01 {
    public static void main(String[] args) throws IOException {
        String directoryPath = "/path/to/directory";  // replace with your directory path
        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("The provided path is not a valid directory!");
            return;
        }

        System.out.println("Scanning directory: " + directoryPath);

        File[] files = directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir, name).isFile();
            }
        });

        if (files != null) {
            for (File file : files) {
                System.out.println("File: " + file.getAbsolutePath());
            }
        } else {
            System.out.println("No files found!");
        }
    }
}