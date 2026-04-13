import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_34263_FileScanner_A03 {
    private static final Set<String> ALLOWED_EXTENSIONS = new HashSet<>(Arrays.asList("txt", "jpg", "jpeg", "png"));

    public static void main(String[] args) {
        File rootDirectory = new File(".");
        String[] files = rootDirectory.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return ALLOWED_EXTENSIONS.contains(getFileExtension(name));
            }
        });

        if (files != null) {
            for (String fileName : files) {
                System.out.println(fileName);
            }
        } else {
            System.out.println("No files found in " + rootDirectory.getAbsolutePath());
        }
    }

    private static String getFileExtension(String filename) {
        if (filename == null) {
            return null;
        }
        int index = filename.lastIndexOf('.');
        if (index == -1) {
            return "";
        }
        return filename.substring(index + 1);
    }
}