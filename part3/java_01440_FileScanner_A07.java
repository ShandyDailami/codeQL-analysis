import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class java_01440_FileScanner_A07 {
    private static class FileVisitor extends SimpleFileVisitor<Path> {
        private String searchTerm;

        public java_01440_FileScanner_A07(String searchTerm) {
            this.searchTerm = searchTerm;
        }

        @Override
        public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
            if (path.toString().contains(searchTerm)) {
                File file = path.toFile();
                FilePermission[] perms = file.getReadableFilePermissions();
                for (FilePermission perm : perms) {
                    if (perm.equals(FilePermission.group(7))) {
                        System.out.println("File " + file.getName() + " has read permission for group " + perm);
                    } else if (perm.equals(FilePermission.other(7))) {
                        System.out.println("File " + file.getName() + " has write permission for group " + perm);
                    } else {
                        System.out.println("File " + file.getName() + " has both read and write permission for group " + perm);
                    }
                }
            }
            return FileVisitResult.CONTINUE;
        }
    }

    public static void main(String[] args) {
        String directory = "/path/to/directory";
        String searchTerm = "searchTerm";
        FileVisitor fileVisitor = new FileVisitor(searchTerm);
        try {
            Files.walkFileTree(Paths.get(directory), fileVisitor);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}