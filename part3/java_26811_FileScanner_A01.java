import java.io.*;

public class java_26811_FileScanner_A01 {
    private static final String SECURITY_PATH = "path/to/security/sensitive/files";
    private static final String DENIED_PATH = "denied/path";

    public static void main(String[] args) {
        FileScanner scanner = new FileScanner(SECURITY_PATH);
        try {
            scanner.scan();
        } catch (SecurityException e) {
            System.out.println("Access Denied: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    static class FileScanner {
        private final String path;
        private File file;

        public java_26811_FileScanner_A01(String path) {
            this.path = path;
            this.file = new File(path);
        }

        public void scan() throws SecurityException {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File f : listFiles) {
                    if (f.isDirectory()) {
                        FileScanner fileScanner = new FileScanner(f.getPath());
                        try {
                            fileScanner.scan();
                        } catch (SecurityException e) {
                            throw new SecurityException("Access Denied: " + e.getMessage());
                        }
                    } else if (isDenied(f.getPath())) {
                        throw new SecurityException("Access Denied: " + f.getPath());
                    }
                }
            } else {
                throw new SecurityException("Access Denied: " + path);
            }
        }

        private boolean isDenied(String path) {
            return path.equals(DENIED_PATH);
        }

        public void close() {
            // Cleanup code here if necessary.
        }
    }
}