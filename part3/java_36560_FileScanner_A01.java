import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_36560_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        File dir = new File("."); // Point this to the directory you want to scan.

        // Get all files in directory.
        File[] files = dir.listFiles();

        // If files exists, loop through them.
        if(files != null) {
            for(File file : files) {
                // If file is text file.
                if(file.isFile() && file.getName().endsWith(".txt")) {
                    Scanner scanner = new Scanner(file);
                    while(scanner.hasNextLine()) {
                        System.out.println(scanner.nextLine());
                    }
                    scanner.close();
                }
            }
        }
    }
}