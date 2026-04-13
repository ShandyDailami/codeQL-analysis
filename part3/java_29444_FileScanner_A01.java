import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;

public class java_29444_FileScanner_A01 {

    private static final Pattern VALID_EXTENSIONS = Pattern.compile("^.+\\.(txt|doc|pdf)$");

    private static final FilenameFilter FILE_FILTER = (dir, name) -> VALID_EXTENSIONS.matcher(name).matches();

    public static void main(String[] args) throws IOException {
        File rootDirectory = new File("src/main/resources");
        scanDirectory(rootDirectory);
    }

    private static void scanDirectory(File directory) throws IOException {
        for (File file : directory.listFiles(FILE_FILTER)) {
            if (file.isDirectory()) {
                scanDirectory(file);
            } else {
                System.out.println("Found file: " + file.getAbsolutePath());
                Path path = Paths.get(file.getAbsolutePath());
                System.out.println("Is file readable? " + Files.isReadable(path));
                System.out.println("Is file writable? " + Files.isWritable(path));
                System.out.println("Is file executable? " + Files.isExecutable(path));
            }
        }
    }
}