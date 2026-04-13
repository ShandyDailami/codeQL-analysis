import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_11753_FileScanner_A08 {
    public static void main(String[] args) {
        // Define the directories and files we want to scan
        File[] dirsToScan = new File[] {
            new File("/path/to/dir1"),
            new File("/path/to/dir2"),
        };

        File[] filesToScan = new File[] {
            new File("/path/to/file1.txt"),
            new File("/path/to/file2.txt"),
        };

        // Define the file extensions we're interested in
        Set<String> extensionsToLookFor = new HashSet<>(Arrays.asList("txt", "log", "bin"));

        // Scan the directories and files
        for (File dir : dirsToScan) {
            scanDirectory(dir, extensionsToLookFor);
        }

        for (File file : filesToScan) {
            if (file.isFile() && extensionsToLookFor.contains(getFileExtension(file.getName()))) {
                System.out.println("Found a file with an undesirable extension: " + file.getName());
            }
        }
    }

    private static void scanDirectory(File dir, Set<String> extensionsToLookFor) {
        File[] listOfFiles = dir.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isDirectory()) {
                    scanDirectory(file, extensionsToLookFor);
                } else if (file.isFile() && extensionsToLookFor.contains(getFileExtension(file.getName()))) {
                    System.out.println("Found a file with an undesirable extension: " + file.getName());
                }
            }
        }
    }

    private static String getFileExtension(String filename) {
        if (filename == null) {
            return null;
        }
        int lastIndex = filename.lastIndexOf('.');
        if (lastIndex == -1) {
            return "";
        }
        return filename.substring(lastIndex + 1).toLowerCase();
    }
}