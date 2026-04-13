import java.io.File;
import java.io.FileFilter;

public class java_27524_FileScanner_A01 {
    public static void main(String[] args) {
        File rootDirectory = new File("."); // Get the current directory

        String[] extensions = {".txt", ".exe", ".pdf", ".docx"}; // Define the file types we are interested in

        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                for (String extension : extensions) {
                    if (pathname.getName().toLowerCase().endsWith(extension)) {
                        return true;
                    }
                }
                return false;
            }
        };

        getFiles(rootDirectory, filter);
    }

    public static void getFiles(File directory, FileFilter filter) {
        File[] files = directory.listFiles(filter); // List all files

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getAbsolutePath()); // Print file paths
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getAbsolutePath()); // Print directory paths
                    getFiles(file, filter); // Recursively list files in subdirectories
                }
            }
        }
    }
}