import java.io.*;
import java.nio.file.*;

public class java_35991_FileScanner_A08 {
    private static final String DIRECTORY = "path_to_directory";

    public static void main(String[] args) throws IOException {
        Path directory = Paths.get(DIRECTORY);

        try (DirectoryStream<Path> directories = Files.newDirectoryStream(directory)) {
            for (Path dir : directories) {
                if (Files.isWritable(dir)) {
                    System.out.println("Directory: " + dir);
                    try (DirectoryStream<Path> files = Files.newDirectoryStream(dir, "*.txt")) {
                        for (Path file : files) {
                            try (InputStream in = Files.newInputStream(file)) {
                                SecurityManager securityManager = new SecurityManager();
                                if (securityManager.checkRead(in)) {
                                    System.out.println("Reading file: " + file);
                                    readFile(in);
                                }
                            } catch (IOException e) {
                                System.err.println("Error reading file: " + file);
                            }
                        }
                    }
                }
            }
        } catch (SecurityException e) {
            System.err.println("Permission denied to read directory: " + directory);
        }
    }

    private static void readFile(InputStream in) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Do something with the line
                System.out.println("Read: " + line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + in);
        }
    }
}