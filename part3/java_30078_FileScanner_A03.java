import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_30078_FileScanner_A03 {
    private final File rootDirectory;
    private final Set<String> safeExtensions;

    public java_30078_FileScanner_A03(File rootDirectory, String... safeExtensions) {
        this.rootDirectory = rootDirectory;
        this.safeExtensions = new HashSet<>(Arrays.asList(safeExtensions));
    }

    public void scan() {
        File[] files = rootDirectory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scan(file);
                } else {
                    processFile(file);
                }
            }
        }
    }

    private void processFile(File file) {
        if (file.isFile() && isSafeFile(file)) {
            System.out.println("Found safe file: " + file.getAbsolutePath());
        }
    }

    private boolean isSafeFile(File file) {
        String name = file.getName();
        int lastDot = name.lastIndexOf('.');
        if (lastDot == -1) {
            return false;
        }
        String extension = name.substring(lastDot + 1);
        return safeExtensions.contains(extension);
    }

    public static void main(String[] args) {
        InjectionFileScanner scanner = new InjectionFileScanner(new File("/path/to/directory"), "exe", "dll", "so", "jar");
        scanner.scan();
    }
}