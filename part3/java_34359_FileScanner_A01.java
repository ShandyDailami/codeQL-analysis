import java.io.*;
import java.nio.file.*;
import java.util.*;

public class java_34359_FileScanner_A01 {
    private static final String DIR = "C:\\Windows\\System32";
    private static final String EXT = "*.dll";

    public static void main(String[] args) {
        try {
            Files.walk(Paths.get(DIR), Integer.MAX_VALUE)
                 .filter(path -> Files.isRegularFile(path) && Files.readable(path))
                 .forEach(SecurityScanner::checkFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void checkFile(Path path) {
        if (path.toString().endsWith(EXT)) {
            System.out.println("Potential security risk: " + path.toString());
            // Add code here to scan and report on the DLL file.
            // For example, use a library to check for known bad practices.
            // Or use a library to call a native system API to get file permissions.
        }
    }
}