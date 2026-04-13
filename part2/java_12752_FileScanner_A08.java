import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_12752_FileScanner_A08 {

    public static void main(String[] args) {

        // create a new scanner for user input
        Scanner scanner = new Scanner(System.in);

        // ask the user for a directory
        System.out.println("Enter a directory:");
        String directory = scanner.next();

        // create a new file
        File file = new File(directory);

        // check if the directory exists
        if (file.exists()) {
            // list all files in the directory
            File[] files = file.listFiles();
            Arrays.stream(files).forEach(System.out::println);
        } else {
            System.out.println("Directory does not exist!");
        }

        // close the scanner
        scanner.close();
    }
}