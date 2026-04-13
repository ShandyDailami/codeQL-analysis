import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class java_05101_FileScanner_A01 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/your/directory";
        File directory = new File(directoryPath);
        findFiles(directory, ".*");
    }

    public static void findFiles(File directory, String extension) {
        File[] matchingFiles = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(extension);
            }
        });

        if (matchingFiles != null) {
            for (File file : matchingFiles) {
                System.out.println(file.getAbsolutePath());
            }
        }

        File[] nestedDirectories = directory.listFiles(File::isDirectory);
        if (nestedDirectories != null) {
            for (File nestedDirectory : nestedDirectories) {
                findFiles(nestedDirectory, extension);
            }
        }
    }
}