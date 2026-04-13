import java.io.File;
import java.io.FileFilter;

public class java_37731_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // Replace with your directory path

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            fileScanner(directory);
        } else {
            System.out.println("Directory not found!");
        }
    }

    public static void fileScanner(File directory) {
        FileFilter filter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".txt");
            }
        };

        File[] txtFiles = directory.listFiles(filter);

        for (File file : txtFiles) {
            System.out.println("File: " + file.getAbsolutePath());
            // Security-sensitive operations like reading a file, e.g., file.read()
            // Here, we are simply printing the file name and ignoring the content
        }
    }
}