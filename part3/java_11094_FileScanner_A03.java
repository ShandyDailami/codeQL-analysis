import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Arrays;

public class java_11094_FileScanner_A03 {

    public static void main(String[] args) throws IOException {
        String directory = args.length > 0 ? args[0] : ".";
        File startingDirectory = new File(directory);
        findJavaFiles(startingDirectory);
    }

    private static void findJavaFiles(File directory) throws IOException {
        FileFilter filter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isDirectory() || (pathname.getName().endsWith(".java"));
            }
        };

        File[] foundFiles = directory.listFiles(filter);

        if (foundFiles != null) {
            Arrays.stream(foundFiles).forEach(FileScanner::printFileInfo);
        }

        for (File file : directory.listFiles(filter)) {
            if (file.isDirectory()) {
                findJavaFiles(file);
            }
        }
    }

    private static void printFileInfo(File file) {
        System.out.println("File: " + file.getAbsolutePath());
    }
}