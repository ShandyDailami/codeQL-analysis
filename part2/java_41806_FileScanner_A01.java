import java.io.File;
import java.io.FileFilter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class java_41806_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = args[0];
        String extension = args[1];

        File dir = new File(directoryPath);

        FileFilter filter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(extension);
            }
        };

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Press any key to stop...");
            scanner.nextLine(); // wait for user to press any key
        }

        Files.walk(Paths.get(directoryPath))
            .filter(path -> Files.isRegularFile(path) && filter.accept(path.toFile()))
            .forEach(FileScanner::printFileInfo);
    }

    private static void printFileInfo(Path path) {
        try {
            FileInfo fileInfo = Files.getFileAttributeView(path, FileAttributeView.FileAttributeViewAccess.readAttributes())
                .standardView().getAttributes();

            System.out.printf("Path: %s%n", path);
            System.out.printf("Last modified: %s%n", fileInfo.lastModifiedTime());
            System.out.printf("Size: %d bytes%n", fileInfo.size());
            System.out.printf("Permissions: %s%n", fileInfo.permissions());
        } catch (IOException e) {
            System.out.printf("Error getting attributes for %s%n", path);
        }
    }
}