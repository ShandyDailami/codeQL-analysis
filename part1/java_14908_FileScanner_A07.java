import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class java_14908_FileScanner_A07 {
    private static final String DIRECTORY = "path_to_your_directory";
    private static final Set<String> FILE_EXTENSIONS = new HashSet<>() {{
        add(".java");
        add(".class");
        // Add more file extensions if necessary
    }};

    public static void main(String[] args) {
        File dir = new File(DIRECTORY);
        findAuthFailures(dir);
    }

    private static void findAuthFailures(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    if (isAuthFailure(file)) {
                        System.out.println("Found AuthFailure in " + file.getAbsolutePath());
                    }
                } else if (file.isDirectory()) {
                    findAuthFailures(file);
                }
            }
        }
    }

    private static boolean isAuthFailure(File file) {
        try {
            Set<String> methods = new HashSet<>();
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("AuthFailure")) {
                    methods.add(line);
                }
            }
            return methods.size() > 0;
        } catch (Exception e) {
            return false;
        }
    }
}