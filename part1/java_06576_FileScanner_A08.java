import java.io.File;
import java.security.Permission;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_06576_FileScanner_A08 {
    private static final String INPUT_DIRECTORY = "C:\\input";
    private static final String OUTPUT_DIRECTORY = "C:\\output";

    public static void main(String[] args) {
        File inputDirectory = new File(INPUT_DIRECTORY);
        File outputDirectory = new File(OUTPUT_DIRECTORY);

        List<String> files = new ArrayList<>();
        readFilesFromDirectory(inputDirectory, files);

        for (String filePath : files) {
            File file = new File(filePath);
            if (file.delete()) {
                System.out.println("Deleted file: " + file.getAbsolutePath());
            } else {
                System.out.println("Failed to delete file: " + file.getAbsolutePath());
            }
        }
    }

    private static void readFilesFromDirectory(File directory, List<String> files) {
        File[] listFiles = directory.listFiles();
        for (File file : listFiles) {
            if (file.isFile()) {
                files.add(file.getAbsolutePath());
            } else if (file.isDirectory()) {
                readFilesFromDirectory(file, files);
            }
        }
    }
}