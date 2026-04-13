import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_01166_FileScanner_A07 {

    public static void main(String[] args) throws Exception {
        Path path = Paths.get(".");

        if (Files.exists(path)) {
            Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    System.out.println(file.toString());
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) {
                    System.err.println(file + " 访问失败: " + exc);
                    return FileVisitResult.CONTINUE;
                }
            });
        } else {
            System.out.println("文件或目录不存在。");
        }
    }
}