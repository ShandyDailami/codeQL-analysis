import java.io.File;
import java.util.Arrays;

public class java_22212_FileScanner_A07 {

    public static void main(String[] args) {
        File currentDir = new File(".");
        printFilesInDirectory(currentDir, "");
    }

    private static void printFilesInDirectory(File directory, String indentation) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    printFilesInDirectory(file, indentation + "  ");
                } else {
                    System.out.println(indentation + file.getName());
                }
            }
        }
    }
}