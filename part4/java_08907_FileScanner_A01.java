import java.io.File;
import java.io.FileFilter;
import java.util.HashSet;
import java.util.Set;

public class java_08907_FileScanner_A01 {
    private static final String BROKEN_STATUS = "Broken";
    private static final Set<String> BROKEN_EXTENSIONS = new HashSet<>();

    static {
        BROKEN_EXTENSIONS.add("txt");
        BROKEN_EXTENSIONS.add("log");
        // Add more extensions if needed
    }

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";

        File directory = new File(directoryPath);

        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                String name = pathname.getName();
                int lastDotIndex = name.lastIndexOf(".");
                String extension = lastDotIndex == -1 ? "" : name.substring(lastDotIndex + 1);
                return !BROKEN_STATUS.equals(extension) &&
                        BROKEN_EXTENSIONS.contains(extension);
            }
        };

        File[] unprotectedFiles = directory.listFiles(filter);

        if (unprotectedFiles != null) {
            for (File file : unprotectedFiles) {
                System.out.println("File '" + file.getPath() + "' is not protected from access control issues.");
            }
        } else {
            System.out.println("No files in '" + directoryPath + "' have access control issues.");
        }
    }
}