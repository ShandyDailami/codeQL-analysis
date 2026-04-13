import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_01199_FileScanner_A03 {

    private static final Set<String> ALLOWED_EXTENSIONS = new HashSet<>(Arrays.asList("txt", "java"));

    public static void main(String[] args) {
        File rootDirectory = new File(".");
        scanDirectory(rootDirectory);
    }

    private static void scanDirectory(File directory) {
        File[] files = directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".java") && ALLOWED_EXTENSIONS.contains(getFileExtension(name));
            }
        });

        if (files != null) {
            for (File file : files) {
                System.out.println("Found file: " + file.getAbsolutePath());
            }
        }

        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                scanDirectory(file);
            }
        }
    }

    private static String getFileExtension(String filename) {
        String extension = "";
        int i = filename.lastIndexOf('.');
        if (i > 0) {
            extension = filename.substring(i + 1);
        }
        return extension;
    }
}