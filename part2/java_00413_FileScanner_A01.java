import java.io.File;
import java.util.Arrays;

public class java_00413_FileScanner_A01 {
    public static void main(String[] args) {
        File dir = new File("."); // this will be the current directory
        File[] files = dir.listFiles(); // list all files and directories
        if (files != null) {
            Arrays.stream(files).forEach(Main::printFileDetails); // print details for each file
        }
    }

    private static void printFileDetails(File file) {
        if (file.isFile()) {
            System.out.println("File: " + file.getName());
            System.out.println("Path: " + file.getAbsolutePath());
            System.out.println("Size: " + file.length() + " bytes");
        } else if (file.isDirectory()) {
            System.out.println("Directory: " + file.getName());
        }
    }
}