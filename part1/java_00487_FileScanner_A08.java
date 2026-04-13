import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class java_00487_FileScanner_A08 {
    private static final String DIRECTORY = "/path/to/directory";  // replace with your directory path
    private static final String FILE_NAME = "file.txt";  // replace with your file name

    public static void main(String[] args) {
        File directory = new File(DIRECTORY);

        try (java.util.Scanner scanner = new java.util.Scanner(System.in)) {
            System.out.println("Enter password:");
            String password = scanner.nextLine();

            if (Files.exists(Paths.get(DIRECTORY), Path::exists, Path::exists)) {
                Files.walkFileTree(directory.toPath(), new SimpleFileVisitor<>() {
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        if (file.toString().endsWith(FILE_NAME) && Files.isSameFile(file.toFile().toPath(), directory.toPath())) {
                            try {
                                Files.setAttribute(file.toFile().toPath(), "user.file.canRead", new byte[] { password.getBytes()[0] }, null);
                                System.out.println("File " + file + " has been accessed, password set for it!");
                            } catch (Exception e) {
                                System.out.println("Error setting password for file " + file + ": " + e.getMessage());
                            }
                        }
                        return FileVisitResult.CONTINUE;
                    }
                });
            } else {
                System.out.println("Directory not found!");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}