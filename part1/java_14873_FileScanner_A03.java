import java.io.*;
import java.nio.file.*;
import java.util.zip.*;

public class java_14873_FileScanner_A03 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("path_to_file"); // replace with your file path
        String searchString = "search_string"; // replace with your string to search

        Files.walk(path)
            .filter(Files::isRegularFile)
            .forEach(file -> {
                try (InputStream in = Files.newInputStream(file)) {
                    try (ZipInputStream zin = new ZipInputStream(in)) {
                        unzipAndScan(zin, searchString);
                    } catch (InvalidObjectException e) {
                        System.out.println("Invalid object in zip file: " + file.toString());
                    }
                } catch (IOException e) {
                    System.out.println("Failed to read file: " + file.toString());
                }
            });
    }

    private static void unzipAndScan(ZipInputStream zin, String searchString) throws IOException {
        ZipEntry entry;
        while ((entry = zin.getNextEntry()) != null) {
            if (entry.isDirectory()) {
                continue;
            }
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(zin))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.contains(searchString)) {
                        System.out.println("Found '" + searchString + "' in file: " + entry.getName());
                    }
                }
            }
            zin.closeEntry();
        }
    }
}