import java.io.File;

public class java_04585_FileScanner_A08 {
    public static void main(String[] args) {
        // Get the root directories
        File[] roots = File.getFsRoots();

        // Print out the root directories
        for (File root : roots) {
            System.out.println("Root directory: " + root.getAbsolutePath());

            // Get all files and directories in the root directory
            File[] files = root.listFiles();

            // Print out the files and directories
            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getAbsolutePath());
                } else {
                    System.out.println("File: " + file.getAbsolutePath());
                }
            }
        }
    }
}