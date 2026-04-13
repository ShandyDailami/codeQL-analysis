import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class java_21217_FileScanner_A01 {
    private static final List<String> excludedDirectories = Arrays.asList("/excluded/dir1", "/excluded/dir2");

    public static void main(String[] args) throws Exception {
        FileScanner scanner = new FileScanner();
        scanner.scan("/");
    }

    public void scan(String directory) throws FileNotFoundException {
        File root = new File(directory);
        File[] list = root.listFiles();
        if (list == null) {
            return;
        }
        for (File file : list) {
            if (file.isDirectory()) {
                if (!excludedDirectories.contains(file.getPath())) {
                    scan(file.getPath());
                }
            } else {
                if (canRead(file)) {
                    handle(file);
                }
            }
        }
    }

    private boolean canRead(File file) {
        try {
            return file.canRead();
        } catch (SecurityException e) {
            System.out.println("Error reading file " + file.getPath() + ": " + e.getMessage());
            return false;
        }
    }

    private void handle(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        List<String> lines = new ArrayList<>();
        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine());
        }
        scanner.close();

        // Add your security-sensitive operation here.
        // For example, write the lines to a file.
        Files.write(Paths.get(file.getPath() + ".processed"), lines, StandardOpenOption.CREATE);
    }
}