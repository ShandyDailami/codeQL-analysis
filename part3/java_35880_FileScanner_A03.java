import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_35880_FileScanner_A03 {
    public static void main(String[] args) {
        Path start = Paths.get(".");

        try (DirectoryStream<Path> ds = Files.newDirectoryStream(start, "*.{txt,log}")) {
            for (Path p : ds.iterator()) {
                FileAttributes attrs = Files.readAttributes(p, BasicFileAttributes.class);
                System.out.println(p.getFileName().toString());
                if (attrs.isSymbolicLink()) {
                    System.out.println("Symbolic link: " + p);
                }
                if (attrs.isRegularFile()) {
                    System.out.println("Regular file: " + p);
                }
                if (attrs.isDirectory()) {
                    System.out.println("Directory: " + p);
                }
                System.out.println("File size: " + attrs.size() + " bytes");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}