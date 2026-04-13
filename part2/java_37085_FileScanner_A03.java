import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class java_37085_FileScanner_A03 {

    private static final String EXTENSION = ".txt";

    public static void main(String[] args) {
        File currentDirectory = new File(".");
        List<File> textFiles = new ArrayList<>();

        // Recursive function to get all text files in the current directory and its subdirectories.
        getTextFilesRecursively(currentDirectory, textFiles);

        // Print out the list of text files.
        System.out.println("List of text files:");
        for (File file : textFiles) {
            System.out.println(file.getAbsolutePath());
        }
    }

    private static void getTextFilesRecursively(File directory, List<File> textFiles) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(EXTENSION)) {
                    textFiles.add(file);
                } else if (file.isDirectory()) {
                    getTextFilesRecursively(file, textFiles);
                }
            }
        }
    }
}