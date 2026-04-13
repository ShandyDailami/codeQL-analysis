import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class java_04416_FileScanner_A01 {

    public static void main(String[] args) {
        try (DirectoryStream<Path> directories = Files.newDirectoryStream(Paths.get("."))) {
            for (Path path : directories) {
                if (Files.isDirectory(path)) {
                    System.out.println("Directory: " + path);
                    printDirectoryContents(path, 1);
                } else {
                    System.out.println("File: " + path);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printDirectoryContents(Path dir, int indentationLevel) {
        try (DirectoryStream<Path> files = Files.newDirectoryStream(dir)) {
            for (Path path : files) {
                printIndentation(indentationLevel);
                System.out.println(path.toString());
                if (Files.isDirectory(path)) {
                    printDirectoryContents(path, indentationLevel + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printIndentation(int indentationLevel) {
        for (int i = 0; i < indentationLevel; i++) {
            System.out.print("    ");
        }
    }
}