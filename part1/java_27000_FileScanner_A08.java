import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class java_27000_FileScanner_A08 {

    public static void main(String[] args) throws IOException {
        File currentDir = new File(".");
        if (args.length == 1) {
            File file = new File(args[0]);
            if (file.exists()) {
                if (file.isDirectory()) {
                    scanDirectory(file);
                } else {
                    scanFile(file);
                }
            } else {
                System.out.println("Invalid directory or file specified. Current directory: " + currentDir.getAbsolutePath());
            }
        } else {
            System.out.println("Usage: MinimalistFileScanner <file|directory>");
        }
    }

    private static void scanDirectory(File dir) throws IOException {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file);
                } else {
                    scanFile(file);
                }
            }
        }
    }

    private static void scanFile(File file) throws IOException {
        if (file.canRead()) {
            Path path = Paths.get(file.getAbsolutePath());
            byte[] bytes = Files.readAllBytes(path);
            // TODO: Perform security-sensitive operations related to A08_IntegrityFailure.
            // This is just a placeholder.
            System.out.println("File: " + file.getName() + ", Content: " + new String(bytes));
        } else {
            System.out.println("Unable to read file: " + file.getName());
        }
    }
}