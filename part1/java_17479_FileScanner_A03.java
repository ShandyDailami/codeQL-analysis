import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_17479_FileScanner_A03 {

    public static void main(String[] args) {
        // Define the directory to scan
        File directory = new File(".");

        // Use a filter to only scan .java files
        FilenameFilter filter = (dir, name) -> name.endsWith(".java");

        // Scan the directory and print out the names of all .java files
        File[] javaFiles = directory.listFiles(filter);
        if (javaFiles != null) {
            Arrays.stream(javaFiles)
                .map(File::getName)
                .forEach(System.out::println);
        }
    }
}