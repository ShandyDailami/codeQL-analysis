import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class java_36190_FileScanner_A07 {

    public static void main(String[] args) {
        try {
            File rootDirectory = new File("/path/to/root/directory");
            FileWriter fileWriter = new FileWriter("./output.txt", true);

            Files.walkFileTree(rootDirectory.toPath(), new SimpleFileVisitor<>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (file.toString().endsWith(".txt")) {
                        Scanner scanner = new Scanner(new FileReader(file.toFile()));
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            fileWriter.write(line + System.lineSeparator());
                        }
                        scanner.close();
                    }
                    return FileVisitResult.CONTINUE;
                }
            });

            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}