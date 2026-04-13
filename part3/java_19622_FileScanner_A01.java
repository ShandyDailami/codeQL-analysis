import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_19622_FileScanner_A01 {
    private static List<String> filePaths = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        try {
            scanFiles(Paths.get(directoryPath));
        } catch (IOException e) {
            System.out.println("Failed to read directory: " + e.getMessage());
        } finally {
            scanner.close();
        }

        for (String path : filePaths) {
            System.out.println(path);
        }
    }

    private static void scanFiles(Path path) throws IOException, DirectoryIteratorException {
        File file = path.toFile();
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                if (f.isDirectory()) {
                    scanFiles(f.toPath());
                } else {
                    filePaths.add(f.getAbsolutePath());
                }
            }
        } else {
            filePaths.add(file.getAbsolutePath());
        }
    }
}