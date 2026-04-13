import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class java_24100_FileScanner_A01 {
    public static void main(String[] args) {
        File rootDir = new File("."); // Current directory

        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                // We only want to scan .java files
                if (name.endsWith(".java")) {
                    return true;
                }
                return false;
            }
        };

        scanDirectory(rootDir, filter);
    }

    private static void scanDirectory(File dir, FilenameFilter filter) {
        File[] listFiles = dir.listFiles(filter);
        if (listFiles == null) {
            return;
        }

        for (File file : listFiles) {
            if (file.isDirectory()) {
                scanDirectory(file, filter);
            } else {
                // We've found a .java file, so now we'll try to break it by accessing its content
                try {
                    byte[] bytecode = Files.readAllBytes(file.toPath());

                    // Here we're just checking if the file is accessible
                    // In a real situation, you'd want to check for more complex security risks
                    System.out.println("Found a potentially dangerous file: " + file);
                } catch (IOException e) {
                    System.out.println("Could not read file: " + file);
                }
            }
        }
    }
}