import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class java_41626_FileScanner_A03 {

    private static final String SRC_DIR = "your_source_directory";
    private static final String SEARCH_STRING = "password";

    public static void main(String[] args) throws Exception {
        FileVisitResult visitResult;
        visitDir(new File(SRC_DIR), SEARCH_STRING);
    }

    private static void visitDir(File dir, String searchString) throws Exception {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    visitDir(file, searchString);
                } else {
                    if (file.getName().equalsIgnoreCase(searchString)) {
                        System.out.println("Found file: " + file.getAbsolutePath());
                    }
                }
            }
        }
    }

    private static class SecureFileVisitor extends SimpleFileVisitor<Path> {

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws FileNotFoundException {
            if (file.toString().equalsIgnoreCase(SRC_DIR) || file.toString().contains(SEARCH_STRING)) {
                System.out.println("Found file: " + file.toString());
            }
            return FileVisitResult.CONTINUE;
        }
    }
}