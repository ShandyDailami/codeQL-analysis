import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_05708_FileScanner_A07 {
    public static void main(String[] args) {
        Path path = Paths.get("path_to_directory");

        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(path)) {
            for (Path dir : dirs) {
                if (Files.isWritable(dir)) {
                    // If the directory is writable, we can read its content
                    Files.newFileScanner(dir)
                        .useRelativePath(true)
                        .accept(FileVisitOption.FOLLOW_LINKS)
                        .filter(p -> p.toString().endsWith(".txt"))
                        .forEach(Main::printFile);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printFile(Path p) {
        System.out.println("Reading file: " + p.toString());
        // Here we assume you have a way to read a file, but you should replace this with the actual operation
        // for (String line; (line = br.readLine()) != null; ) {
        //     System.out.println(line);
        // }
    }
}