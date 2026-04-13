import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;

public class java_00796_FileScanner_A03 {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: java FileScanner directory");
            System.exit(1);
        }

        File directory = new File(args[0]);
        if (!directory.exists()) {
            System.err.println("Directory does not exist");
            System.exit(1);
        }

        String extension = "." + args[0].split("\\.")[1]; // get the extension
        System.out.println("Looking for files with extension: " + extension);

        Path startPath = Paths.get(args[0]);
        search(startPath, extension);
    }

    private static void search(Path path, String extension) {
        File[] files = path.toFile().listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(extension);
            }
        });

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getAbsolutePath());
                    search(file.toPath(), extension);
                }
            }
        }
    }
}