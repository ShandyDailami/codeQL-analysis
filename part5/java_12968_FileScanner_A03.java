import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

public class java_12968_FileScanner_A03 {
    private static final String ROOT_PATH = "/path/to/scan";

    public List<File> scanDirectory(String rootPath) {
        List<File> files = new ArrayList<>();

        File file = new File(rootPath);
        FileFilter filter = (dir, name) -> name.endsWith(".java");

        getFilesRecursively(file, filter, files);

        return files;
    }

    private void getFilesRecursively(File root, FileFilter filter, List<File> files) {
        File[] foundFiles = root.listFiles(filter);

        if (foundFiles != null) {
            for (File file : foundFiles) {
                if (file.isDirectory()) {
                    getFilesRecursively(file, filter, files);
                } else {
                    files.add(file);
                }
            }
        }
    }

    public static void main(String[] args) {
        SecurityScanner scanner = new SecurityScanner();
        List<File> files = scanner.scanDirectory(ROOT_PATH);

        for (File file : files) {
            System.out.println("Found Java file: " + file.getPath());
        }
    }
}