import java.io.File;
import java.util.Arrays;

public class java_06857_FileScanner_A07 {
    public static void main(String[] args) {
        // Create a File object for the directory you want to scan
        File directory = new File(".");

        // Use the listFiles method to get an array of File objects representing the files in the directory
        File[] files = directory.listFiles();

        // Use the Arrays.stream method to convert the array of File objects into a stream
        // The map method is used to print the names of each file
        Arrays.stream(files)
              .map(File::toString)
              .forEach(System.out::println);
    }
}