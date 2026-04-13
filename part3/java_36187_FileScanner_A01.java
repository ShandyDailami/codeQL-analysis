import java.io.File;
import java.io.FileFilter;

public class java_36187_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // Replace with your directory path

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles(new FileFilter() {
                public boolean accept(File pathname) {
                    return pathname.isFile() && pathname.getName().endsWith(".txt");
                }
            });

            for (File file : files) {
                // Process the file here
                System.out.println("File: " + file.getAbsolutePath());
            }
        } else {
            System.out.println("Directory not found.");
        }
    }
}