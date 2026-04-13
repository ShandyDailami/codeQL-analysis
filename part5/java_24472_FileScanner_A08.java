import java.io.File;
import java.util.List;
import java.util.ArrayList;

public class java_24472_FileScanner_A08 {
    public static void main(String[] args) {
        File rootDirectory = new File(".");
        List<File> allFiles = new ArrayList<>();
        getAllFiles(rootDirectory, allFiles);

        // Here you could perform security-sensitive operations on allFiles, for example:
        for (File file : allFiles) {
            // Check if the file is a directory and not hidden
            if (file.isDirectory() && !file.getName().startsWith(".")) {
                // Here you could perform some security-sensitive operation related to A08_IntegrityFailure
                // For example, check if the file is writable
                if (file.canWrite()) {
                    System.out.println("Found a writable directory: " + file.getPath());
                }
            }
        }
    }

    private static void getAllFiles(File directory, List<File> allFiles) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory() && !file.getName().startsWith(".")) {
                    getAllFiles(file, allFiles);
                } else if (file.isFile()) {
                    allFiles.add(file);
                }
            }
        }
    }
}