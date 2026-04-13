import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class java_15949_FileScanner_A08 {
    private static final Set<String> EXTENSIONS = new HashSet<>();

    static {
        EXTENSIONS.add(".txt");
        EXTENSIONS.add(".csv");
        // add more file extensions if needed
    }

    public static void main(String[] args) {
        File rootDirectory = new File("path_to_your_directory");

        scanDirectory(rootDirectory);
    }

    private static void scanDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files == null) {
            // if there's nothing in this directory, there's nothing else to do
            return;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                // if the file is a directory, recurse into it
                scanDirectory(file);
            } else {
                // if the file is a regular file, check its extension
                String fileExtension = getFileExtension(file);
                if (EXTENSIONS.contains(fileExtension)) {
                    // if the file is of a recognized type, print out some information
                    System.out.printf("Found file of type %s: %s\n", fileExtension, file.getAbsolutePath());
                }
            }
        }
    }

    private static String getFileExtension(File file) {
        String name = file.getName();
        int lastIndex = name.lastIndexOf('.');
        if (lastIndex == -1) {
            return "";
        }

        return name.substring(lastIndex + 1);
    }
}