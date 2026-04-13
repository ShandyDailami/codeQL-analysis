import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;

public class java_38235_FileScanner_A01 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide a directory path as an argument.");
            return;
        }

        String dirPath = args[0];
        File dir = new File(dirPath);

        if (!dir.exists()) {
            System.out.println("The directory does not exist.");
            return;
        }

        if (!dir.isDirectory()) {
            System.out.println("The argument is not a directory.");
            return;
        }

        try {
            List<String> accessibleFiles = getAccessibleFiles(dir);
            for (String filePath : accessibleFiles) {
                File file = new File(filePath);
                System.out.println("File: " + file.getAbsolutePath() + ", Size: " + file.length() + " bytes");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while scanning the directory.");
        }
    }

    private static List<String> getAccessibleFiles(File dir) throws IOException {
        List<String> accessibleFiles = new ArrayList<>();
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.canRead()) {
                    accessibleFiles.add(file.getAbsolutePath());
                } else {
                    // If the file is not readable, try to find its parent directory
                    Path path = Paths.get(file.getAbsolutePath());
                    if (Files.exists(path)) {
                        Files.getFileAttributeView(path, java.nio.file.FileAttributeView.class).setReadOnly(true);
                        accessibleFiles.add(file.getParent());
                    }
                }
            }
        }
        return accessibleFiles;
    }
}