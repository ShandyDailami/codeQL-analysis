import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.security.AccessDeniedException;
import java.security.GeneralSecurityException;

public class java_07928_FileScanner_A08 {
    private String directory;
    private String extension;

    public java_07928_FileScanner_A08(String directory, String extension) {
        this.directory = directory;
        this.extension = extension;
    }

    public void scan() throws AccessDeniedException, GeneralSecurityException, IOException {
        File root = new File(directory);
        if (root.exists() && root.isDirectory()) {
            File[] files = root.listFiles(new FileFilter() {
                public boolean accept(File pathname) {
                    return pathname.isFile() && pathname.getName().endsWith(extension);
                }
            });
            if (files != null) {
                for (File file : files) {
                    // Add your security-sensitive operations here
                    System.out.println("File found: " + file.getAbsolutePath());
                }
            } else {
                throw new AccessDeniedException("Access to directory is denied.");
            }
        } else {
            throw new GeneralSecurityException("Directory not found or not accessible.");
        }
    }

    public static void main(String[] args) {
        try {
            new FileScanner(".", ".txt").scan();
        } catch (AccessDeniedException | GeneralSecurityException | IOException e) {
            e.printStackTrace();
        }
    }
}