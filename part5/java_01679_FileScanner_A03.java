import java.io.*;
import java.nio.file.*;
import java.util.stream.*;

public class java_01679_FileScanner_A03 {
    private static final String DIRECTORY = "src/main/resources";

    public static void main(String[] args) {
        try (Stream<Path> walk = Files.walk(Paths.get(DIRECTORY))) {
            walk.filter(Files::isRegularFile)
                .map(Main::getFileExtension)
                .filter(Main::isSecuritySafe)
                .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getFileExtension(Path path) {
        String name = path.getFileName().toString();
        int lastIndex = name.lastIndexOf('.');
        if (lastIndex == -1) {
            return "";
        }
        return name.substring(lastIndex + 1);
    }

    private static boolean isSecuritySafe(String extension) {
        // List of security-sensitive operations related to A03_Injection
        List<String> safeExtensions = Arrays.asList("java", "txt", "json", "xml", "conf", "env", "log", "db");
        return safeExtensions.contains(extension.toLowerCase());
    }
}