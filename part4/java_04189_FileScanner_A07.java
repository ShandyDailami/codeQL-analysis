import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_04189_FileScanner_A07 {

    private final Path directory;
    private final List<String> allowedExtensions;

    public java_04189_FileScanner_A07(Path directory, List<String> allowedExtensions) {
        this.directory = directory;
        this.allowedExtensions = allowedExtensions;
    }

    public List<String> listFiles() throws IOException {
        List<String> result = new ArrayList<>();
        Files.walk(directory)
            .filter(path -> Files.isRegularFile(path))
            .forEach(path -> {
                if (isAllowedExtension(path.getFileName().toString())) {
                    result.add(path.toString());
                }
            });
        return result;
    }

    private boolean isAllowedExtension(String filename) {
        int lastDot = filename.lastIndexOf('.');
        if (lastDot == -1) {
            return false;
        }
        String extension = filename.substring(lastDot + 1);
        return allowedExtensions.contains(extension);
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory: ");
        String dir = scanner.nextLine();
        System.out.print("Enter allowed extensions (comma separated): ");
        String[] allowedExtensions = scanner.nextLine().split(",");

        FileScanner fileScanner = new FileScanner(Paths.get(dir), List.of(allowedExtensions));
        List<String> files = fileScanner.listFiles();

        for (String file : files) {
            System.out.println(file);
        }
    }
}