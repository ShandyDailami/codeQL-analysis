import java.io.*;
import java.util.zip.*;

public class java_08128_FileScanner_A07 {
    private static final String DIRECTORY = "/path/to/directory";
    private static final String FILE_EXTENSION = "txt";

    public static void main(String[] args) {
        try {
            scanDirectory(new File(DIRECTORY));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void scanDirectory(File directory) throws Exception {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file);
                } else if (file.getName().endsWith(FILE_EXTENSION)) {
                    processFile(file);
                }
            }
        }
    }

    private static void processFile(File file) {
        try (ZipInputStream zipIn = new ZipInputStream(new FileInputStream(file))) {
            ZipEntry entry = zipIn.getNextEntry();
            while (entry != null) {
                if (entry.isFile()) {
                    String fileName = entry.getName();
                    System.out.println("Processing file: " + fileName);
                    // Add security-sensitive operations here
                }
                entry = zipIn.getNextEntry();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}