import java.io.*;
import java.nio.file.*;

public class java_00394_FileScanner_A01 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/main/java/");
        try (Stream<Path> walk = Files.walk(path, 1)) {
            boolean found = false;
            for (Path p : walk) {
                if (p.toString().endsWith(".java")) {
                    try (Stream<String> lines = Files.lines(p)) {
                        boolean foundAccess = false;
                        for (String line : lines) {
                            if (line.trim().startsWith("package")
                                    && line.trim().endsWith(";")) {
                                foundAccess = true;
                                break;
                            }
                        }
                        if (foundAccess) {
                            found = true;
                            System.out.println("Found package statement in file: " + p);
                            break;
                        }
                    }
                }
            }
            if (!found) {
                System.out.println("No package statement found in src directory.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}