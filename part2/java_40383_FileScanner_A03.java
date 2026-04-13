import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class java_40383_FileScanner_A03 {
    public static void main(String[] args) {
        Set<String> extensions = new HashSet<>();
        extensions.add(".txt");
        extensions.add(".pdf");

        String directoryPath = "C:\\example_dir"; // replace with your directory path
        File dir = new File(directoryPath);

        try {
            findFilesWithExtensions(dir, extensions);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void findFilesWithExtensions(File directory, Set<String> extensions) throws IOException {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    String name = file.getName();
                    if (name.toLowerCase().endsWith(extensions.toArray()[0])) {
                        System.out.println("Found file: " + file.getAbsolutePath());
                    }
                } else if (file.isDirectory()) {
                    findFilesWithExtensions(file, extensions);
                }
            }
        }
    }
}