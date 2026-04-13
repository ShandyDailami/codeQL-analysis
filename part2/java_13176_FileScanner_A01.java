import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class java_13176_FileScanner_A01 {
    private final File[] roots;

    public java_13176_FileScanner_A01(File... roots) {
        this.roots = roots;
    }

    public Stream<File> list() {
        return Arrays.stream(roots).flatMap(this::listFiles);
    }

    private Stream<File> listFiles(File root) {
        return listFiles(root, false);
    }

    private Stream<File> listFiles(File root, boolean recurse) {
        File[] files = root.listFiles();
        List<File> dirs = Arrays.asList(files);

        return Stream.concat(
                Arrays.stream(files).map(File::toPath),
                dirs.stream().flatMap(dir -> {
                    if (recurse) {
                        return listFiles(dir, recurse).stream();
                    } else {
                        return Stream.empty();
                    }
                }).map(File::getPath);
    }

    public static void main(String[] args) {
        FileScanner scanner = new FileScanner(new File("."));

        scanner.list().forEach(System.out::println);
    }
}