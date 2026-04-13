import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_24986_FileScanner_A03 {

    public static void main(String[] args) throws Exception {
        Path startingDirectory = Paths.get(".");

        Files.walkFileTree(startingDirectory, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.toString().endsWith(".java")) {
                    processJavaFile(file);
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }

    private static void processJavaFile(Path file) {
        // Here you would put the code to scan and secure the Java file.
        // For example, you might read the file, check for possible injections, etc.

        System.out.println("Processing file: " + file.toString());

        // For now, just print the file name
        try (BufferedReader reader = new BufferedReader(Files.newBufferedReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}