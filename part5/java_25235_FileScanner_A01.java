import java.nio.file.*;
import java.io.*;

public class java_25235_FileScanner_A01 {

    public static void main(String[] args) {

        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*.txt");

        try (Stream<Path> paths = Files.newDirectoryStream(Paths.get("."), matcher)) {
            paths.forEach(Main::process);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void process(Path path) {
        if (Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)) {
            return;
        }

        try (InputStream in = Files.newInputStream(path)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}