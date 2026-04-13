import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class java_34610_FileScanner_A03 {

    private static final Pattern VALID_EXTENSIONS = Pattern.compile("^.+\\.txt$");

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory/";
        File directory = new File(directoryPath);
        if (directory.exists() && directory.isDirectory()) {
            scanDirectory(directory);
        } else {
            System.out.println("The provided path is not a valid directory.");
        }
    }

    private static void scanDirectory(File directory) {
        File[] files = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.isDirectory()) {
                    return true;
                } else {
                    return VALID_EXTENSIONS.matcher(pathname.getName()).matches();
                }
            }
        });

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    printFileInfo(file);
                } else {
                    System.out.println("Encountered subdirectory: " + file.getPath());
                }
            }
        }
    }

    private static void printFileInfo(File file) {
        System.out.printf("File: %s%n", file.getPath());
        System.out.printf("Last modified: %s%n", file.lastModified());
        System.out.printf("Length: %d bytes%n", file.length());
    }
}