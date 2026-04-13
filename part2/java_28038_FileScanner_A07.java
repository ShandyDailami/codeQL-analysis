import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class java_28038_FileScanner_A07 {
    public static void main(String[] args) {
        File dir = new File("your/directory/path");
        List<File> list = new ArrayList<>();

        // Get a list of all files in the directory
        File[] files = dir.listFiles();

        // If no files, exit early
        if (files == null) return;

        // Find and print all .txt files
        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                list.add(file);
            }
        }

        // Print out the list of .txt files
        for (File file : list) {
            System.out.println(file.getName());
        }
    }
}