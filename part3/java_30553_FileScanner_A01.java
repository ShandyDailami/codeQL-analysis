import java.nio.file.*;
import java.io.*;

public class java_30553_FileScanner_A01 {
    public static void main(String[] args) {
        Path path = Paths.get("."); // Change to your directory
        try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(path)) {
            for (Path entry : dirStream) {
                if (Files.isRegularFile(entry)) {
                    File file = entry.toFile();
                    FileInfo fileInfo = new FileInfo(file.getName(), file.length(), file.lastModified());
                    System.out.println(fileInfo.toString());
                } else if (Files.isDirectory(entry)) {
                    System.out.println("Directory: " + entry.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class FileInfo {
    private String name;
    private long size;
    private long lastModified;

    public java_30553_FileScanner_A01(String name, long size, long lastModified) {
        this.name = name;
        this.size = size;
        this.lastModified = lastModified;
    }

    @Override
    public String toString() {
        return "File: " + name + ", Size: " + size + ", Last Modified: " + lastModified;
    }
}