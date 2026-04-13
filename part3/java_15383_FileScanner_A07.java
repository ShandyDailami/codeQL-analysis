import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_15383_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File("path_to_your_directory");
        List<String> fileNames = new ArrayList<>();

        // Use FileScanner to list all files in a directory
        File[] foundFiles = file.listFiles();
        if (foundFiles != null) {
            for (File f : foundFiles) {
                if (f.isFile()) {
                    fileNames.add(f.getName());
                }
            }
        }

        // Print file names
        for (String name : fileNames) {
            System.out.println(name);
        }
    }
}