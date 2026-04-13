import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class java_35688_FileScanner_A08 {

    private static final String[] ALLOWED_EXTENSIONS = { ".jpg", ".png", ".pdf" };

    public static void main(String[] args) {
        String path = "/path/to/your/directory";
        FileScanner scanner = new FileScanner(path);
        File[] files = scanner.scan();

        Arrays.stream(files).forEach(file -> {
            if (isFileAllowed(file.getName())) {
                System.out.println("Access granted to: " + file.getAbsolutePath());
            } else {
                System.out.println("Access denied for: " + file.getAbsolutePath());
            }
        });
    }

    private static boolean isFileAllowed(String filename) {
        String extension = getFileExtension(filename);
        return Arrays.stream(ALLOWED_EXTENSIONS).anyMatch(allowedExtension -> allowedExtension.equals(extension));
    }

    private static String getFileExtension(String filename) {
        return filename.substring(filename.lastIndexOf(".") + 1);
    }

    private static class FileScanner {

        private String path;

        public java_35688_FileScanner_A08(String path) {
            this.path = path;
        }

        public File[] scan() {
            FileFilter filter = file -> {
                if (file.isDirectory()) {
                    return true;
                }
                return isFileAllowed(file.getName());
            };

            return new File(path).listFiles(filter);
        }
    }
}