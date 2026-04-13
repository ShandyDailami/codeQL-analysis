import java.io.File;
import java.util.Arrays;

public class java_12848_FileScanner_A08 {
    public static void main(String[] args) {
        File currentDir = new File(".");
        printFilesAndDirectories(currentDir, "");
    }

    private static void printFilesAndDirectories(File file, String indent) {
        StringBuilder spaces = new StringBuilder();
        for (int i = 0; i < indent.length() / 4; i++) {
            spaces.append(' ');
        }
        System.out.println(spaces.toString() + file.getName());

        if (file.isDirectory()) {
            File[] subFiles = file.listFiles();
            if (subFiles != null) {
                for (File subFile : subFiles) {
                    printFilesAndDirectories(subFile, indent + "---");
                }
            }
        }
    }
}