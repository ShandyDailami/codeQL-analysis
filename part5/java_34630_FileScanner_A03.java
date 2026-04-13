import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_34630_FileScanner_A03 {
    private static final String DIRECTORY = "path_to_directory";

    public static void main(String[] args) {
        File directory = new File(DIRECTORY);
        secureFileSearch(directory);
    }

    private static void secureFileSearch(File directory) {
        File[] files = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return (pathname.isFile() && pathname.getName().endsWith(".txt"));
            }
        });

        if (files != null) {
            Arrays.stream(files).forEach(file -> readFile(file));
        }
    }

    private static void readFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // process the line here, but do not print it, as this could be a potential injection point
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + file.getName());
        }
    }
}