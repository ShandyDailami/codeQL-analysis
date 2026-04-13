import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class java_31957_FileScanner_A01 {
    private static final String ROOT_DIRECTORY = "./";

    public static void main(String[] args) throws IOException {
        File root = new File(ROOT_DIRECTORY);

        // Use a FileFilter to only look for .txt files
        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt");
            }
        };

        // Scan the root directory and all its subdirectories
        File[] files = root.listFiles(filter);
        if (files != null) {
            for (File file : files) {
                // Check if the file is a directory or a file
                if (file.isFile()) {
                    // Print the file's name and size
                    System.out.println("File: " + file.getName() + ", Size: " + file.length() + " bytes");
                } else if (file.isDirectory()) {
                    // Print the directory's name
                    System.out.println("Directory: " + file.getName());
                }
            }
        }
    }
}