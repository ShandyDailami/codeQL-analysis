import java.io.File;
import java.io.FileFilter;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class java_10199_FileScanner_A08 {
    private final File rootDirectory;
    private final String fileExtension;

    public java_10199_FileScanner_A08(File rootDirectory, String fileExtension) {
        this.rootDirectory = rootDirectory;
        this.fileExtension = fileExtension;
    }

    public List<File> scan() {
        List<File> matchingFiles = new ArrayList<>();

        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(fileExtension);
            }
        };

        File[] foundFiles = rootDirectory.listFiles(filter);

        if (foundFiles != null) {
            matchingFiles.addAll(Arrays.asList(foundFiles));
        }

        return matchingFiles;
    }

    public static void main(String[] args) {
        File rootDirectory = new File(".");
        FileScanner scanner = new FileScanner(rootDirectory, ".txt");

        List<File> matchingFiles = scanner.scan();

        for (File file : matchingFiles) {
            System.out.println("Found file: " + file.getAbsolutePath());
        }
    }
}