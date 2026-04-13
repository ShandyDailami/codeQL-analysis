import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

public class java_12462_FileScanner_A07 {
    private static final Pattern VALID_EXTENSIONS = Pattern.compile("^.+\\.(txt|java)$", Pattern.CASE_INSENSITIVE);

    private java_12462_FileScanner_A07() {
        // Hide utility class constructor
    }

    public static void main(String[] args) {
        String directoryPath = args.length == 0 ? "." : args[0];

        File startingDirectory = new File(directoryPath);
        if (!startingDirectory.exists() || !startingDirectory.isDirectory()) {
            System.out.println("Invalid directory: " + startingDirectory);
            return;
        }

        printFiles(startingDirectory, file -> true);
    }

    private static void printFiles(File directory, FileFilter filter) {
        File[] files = directory.listFiles(filter);
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && VALID_EXTENSIONS.matcher(file.getName()).matches()) {
                    System.out.println(file.getName());
                } else if (file.isDirectory()) {
                    printFiles(file, filter);
                }
            }
        }
    }
}