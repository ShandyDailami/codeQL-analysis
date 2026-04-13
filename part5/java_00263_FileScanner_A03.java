import java.io.File;
import java.util.Scanner;

public class java_00263_FileScanner_A03 {
    public static void main(String[] args) {
        File directory = new File(".");

        // Use File's list method to get list of file names
        String[] list = directory.list();

        // Print the list of file names
        if (list != null) {
            for (String name : list) {
                System.out.println(name);
            }
        } else {
            System.out.println("No files found in current directory.");
        }
    }
}