import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class java_03749_FileScanner_A07 {
    private static final String AUTH_FAILURE_DIR = "/path/to/auth/failure/directory";

    public static void main(String[] args) {
        File authFailDirectory = new File(AUTH_FAILURE_DIR);
        if (authFailDirectory.exists()) {
            File[] authFailFiles = authFailDirectory.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".txt");
                }
            });

            if (authFailFiles != null) {
                for (File file : authFailFiles) {
                    if (file.canRead()) {
                        System.out.println("Reading file: " + file.getAbsolutePath());
                    } else {
                        System.out.println("Cannot read file: " + file.getAbsolutePath());
                    }
                }
            }
        } else {
            System.out.println("Directory: " + AUTH_FAILURE_DIR + " not found");
        }
    }
}