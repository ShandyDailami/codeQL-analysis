import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class java_08013_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // Replace with the path of the directory you want to scan
        String extension = ".java"; // Replace with the file extension you want to scan

        File directory = new File(directoryPath);

        // Using anonymous inner class
        File[] files = directory.listFiles(new FileFilter() {
            public boolean accept(File file) {
                return file.getName().endsWith(extension);
            }
        });

        // Using lambda expression
        // File[] files = directory.listFiles((File file) -> file.getName().endsWith(extension));

        // Using method reference
        // File[] files = directory.listFiles(Main::isJavaFile);

        // Printing out the files
        for (File file : files) {
            System.out.println(file.getName());
        }
    }

    // Method to check if a file is a Java file
    public static boolean isJavaFile(File file) {
        return file.getName().endsWith(".java");
    }
}