import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class java_37847_FileScanner_A01 {

    private static final Pattern VALID_EXTENSIONS = Pattern.compile("^.+\\.([a-zA-Z0-9]+)$");

    public static void main(String[] args) {
        File directory = new File("."); // Use current directory
        String extension = "txt"; // Set the file extension

        if (args.length > 0) {
            directory = new File(args[0]);
        }

        if (args.length > 1) {
            extension = args[1];
        }

        File[] allFiles = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return VALID_EXTENSIONS.matcher(pathname.getName()).matches();
            }
        });

        if (allFiles != null) {
            for (File file : allFiles) {
                if (file.isFile() && file.getName().endsWith(extension)) {
                    printFile(file);
                }
            }
        }
    }

    private static void printFile(File file) {
        System.out.println("File: " + file.getAbsolutePath());
    }
}