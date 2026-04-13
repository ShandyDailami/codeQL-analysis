import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_30527_FileScanner_A07 {
    private static final Set<String> AUTH_FAILURE_FILES = new HashSet<>(Arrays.asList(".auth", ".bin", ".db", ".dat", ".txt"));

    public Set<String> scanDirectory(String directoryPath) {
        File dir = new File(directoryPath);
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("The specified directory does not exist or is not a directory.");
            return new HashSet<>();
        }

        File[] files = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                // We only accept .auth files and directories
                return name.toLowerCase().endsWith(".auth") || new File(dir, name).isDirectory();
            }
        });

        Set<String> authFailureFiles = new HashSet<>();
        for (File file : files) {
            if (file.isFile()) {
                String name = file.getName();
                int lastDot = name.lastIndexOf('.');
                if (lastDot != -1) {
                    name = name.substring(0, lastDot);
                }

                if (AUTH_FAILURE_FILES.contains(name)) {
                    authFailureFiles.add(file.getAbsolutePath());
                }
            }
        }

        return authFailureFiles;
    }

    public static void main(String[] args) {
        SecureFileScanner scanner = new SecureFileScanner();
        Set<String> authFailureFiles = scanner.scanDirectory("/path/to/directory");
        for (String file : authFailureFiles) {
            System.out.println(file);
        }
    }
}