import java.io.*;
import java.nio.file.*;

public class java_35902_FileScanner_A01 {
    public static void main(String[] args) {
        Path path = Paths.get(".");
        try (DirectoryStream<Path> ds = Files.newDirectoryStream(path, "*.java")) {
            for (Path p : ds) {
                try (BufferedReader br = Files.newBufferedReader(p)) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        if (line.trim().startsWith("//")) {
                            System.out.println("Ignoring non-security-sensitive operation");
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}