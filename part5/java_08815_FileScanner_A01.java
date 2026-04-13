import java.io.File;
import java.io.IOException;

public class java_08815_FileScanner_A01 {
    public static void main(String[] args) throws IOException {
        String startDirectory = "/path/to/directory"; // replace with your directory
        File startFile = new File(startDirectory);
        printFilesAndDirectories(startFile, 0);
    }

    private static void printFilesAndDirectories(File file, int level) {
        StringBuilder indentation = new StringBuilder(String.format("%" + (10 * level) + "s", "").replace(' ', '*'));
        System.out.println(indentation + file.getName());

        if (file.isDirectory()) {
            File[] subFiles = file.listFiles();
            if (subFiles != null) {
                for (File subFile : subFiles) {
                    printFilesAndDirectories(subFile, level + 1);
                }
            }
        }
    }
}