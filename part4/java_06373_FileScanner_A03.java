import java.nio.file.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class java_06373_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String dirPath = scanner.nextLine();
        System.out.print("Enter the file name pattern (optional): ");
        String pattern = scanner.nextLine();

        Path dir = Paths.get(dirPath);
        try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(dir)) {
            if (pattern.isEmpty()) {
                for (Path path : dirStream) {
                    if (Files.isRegularFile(path)) {
                        System.out.println(path.getFileName());
                    }
                }
            } else {
                Pattern regex = Pattern.compile(pattern);
                for (Path path : dirStream) {
                    if (Files.isRegularFile(path) && regex.matcher(path.getFileName()).matches()) {
                        System.out.println(path.getFileName());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}