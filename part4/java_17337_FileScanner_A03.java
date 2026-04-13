import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class java_17337_FileScanner_A03 {
    private static class FilterVisitor extends FileVisitor<Path> {
        private String[] filterFiles;

        public java_17337_FileScanner_A03(String[] filterFiles) {
            this.filterFiles = filterFiles;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            String path = dir.toAbsolutePath().toString();
            for (String file : filterFiles) {
                if (path.contains(file)) {
                    return FileVisitResult.SKIP_SUBTREE;
                }
            }
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            String path = file.toAbsolutePath().toString();
            for (String fileToFilter : filterFiles) {
                if (path.contains(fileToFilter)) {
                    return FileVisitResult.TERMINATE;
                }
            }
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            return FileVisitResult.CONTINUE;
        }
    }

    public static void main(String[] args) throws IOException {
        String[] filterFiles = {"filter1", "filter2", "filter3"};
        File root = new File("root");
        if (root.exists()) {
            FileVisitor<Path> visitor = new FilterVisitor(filterFiles);
            java.nio.file.Files.walkFileTree(root.toPath(), visitor);
        }
    }
}