import java.io.File;
import java.util.Arrays;

public class java_16568_FileScanner_A03 {
    public static void main(String[] args) {
        // Get the current directory
        File currentDir = new File(".");

        // List all the files and folders in the current directory
        File[] listOfFiles = currentDir.listFiles();

        // If listOfFiles is not null, print out the names of all files and folders
        if (listOfFiles != null) {
            Arrays.stream(listOfFiles).forEach(file -> {
                System.out.println(file.getName());
            });
        } else {
            System.out.println("No files or directories found in the current directory!");
        }
    }
}