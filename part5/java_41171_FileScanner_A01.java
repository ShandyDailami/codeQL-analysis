import java.io.File;
import java.util.Arrays;
import java.util.List;

public class java_41171_FileScanner_A01 {

    private static final List<String> EXTENSIONS = Arrays.asList("txt");
    private static final String ROOT_DIRECTORY = "/path/to/directory";

    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        File root = new File(ROOT_DIRECTORY);

        scanner.scan(root, EXTENSIONS, file -> {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                System.out.println("Text file: " + file.getAbsolutePath());
            }
        });
    }
}

class FileScanner {

    void scan(File root, List<String> extensions, FileVisitor visitor) {
        File[] files = root.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scan(file, extensions, visitor);
                } else if (file.isFile() && hasMatchingExtension(file, extensions)) {
                    visitor.visit(file);
                }
            }
        }
    }

    private boolean hasMatchingExtension(File file, List<String> extensions) {
        String name = file.getName();
        int lastDot = name.lastIndexOf(".");

        if (lastDot == -1) {
            return false;
        }

        String extension = name.substring(lastDot + 1).toLowerCase();

        return extensions.contains(extension);
    }
}

interface FileVisitor {

    void visit(File file);
}