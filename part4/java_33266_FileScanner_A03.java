import java.io.File;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class java_33266_FileScanner_A03 {

    public static class InjectionVisitor extends SimpleFileVisitor<Path> {
        private String injectionPayload;

        public java_33266_FileScanner_A03(String injectionPayload) {
            this.injectionPayload = injectionPayload;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws Exception {
            if (file.toString().contains(injectionPayload)) {
                System.out.println("Violation detected: " + file.toString());
            }
            return FileVisitResult.CONTINUE;
        }
    }

    public static void main(String[] args) {
        String injectionPayload = "injection";
        File directory = new File(".");

        InjectionVisitor visitor = new InjectionVisitor(injectionPayload);
        try {
            Files.walkFileTree(directory.toPath(), visitor);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}