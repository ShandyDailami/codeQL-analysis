import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class java_21440_FileScanner_A01 {
    public static void main(String[] args) {
        File file = new File(".");
        String[] files = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt");
            }
        });

        if (files != null) {
            Arrays.sort(files);
            for (String fileName : files) {
                System.out.println("File name: " + fileName);
                // Assume we have a function to access a file for security sensitive operation here.
                accessFile(fileName);
            }
        }
    }

    private static void accessFile(String fileName) {
        // Code to access and read the file. 
        // This is a placeholder and does not actually do anything.
        System.out.println("Accessing and reading file: " + fileName);
    }
}