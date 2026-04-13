import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class java_06744_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "path/to/directory";  // replace with your directory path
        FileVisitor fileVisitor = new FileVisitor();

        try {
            fileVisitor.visitFile(new File(directoryPath), false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class FileVisitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (file.toString().endsWith(".txt")) {  // filter for .txt files
                readFile(file);
            }
            return FileVisitResult.CONTINUE;
        }

        private void readFile(Path file) {
            try (BufferedReader reader = Files.newBufferedReader(file)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}