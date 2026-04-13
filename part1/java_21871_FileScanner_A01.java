import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class java_21871_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path

        File directory = new File(directoryPath);

        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt");
            }
        };

        try {
            searchFiles(directory, filter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void searchFiles(File directory, FilenameFilter filter) {
        File[] files = directory.listFiles(filter);

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    searchFiles(file, filter);
                } else {
                    System.out.println("File: " + file.getAbsolutePath());
                }
            }
        }
    }
}