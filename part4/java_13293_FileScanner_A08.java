import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_13293_FileScanner_A08 {

    public static void main(String[] args) {
        // get the current directory
        File currentDir = new File(".");

        // iterate over all files in the current directory
        for (File file : currentDir.listFiles()) {
            if (!file.isDirectory()) {
                try {
                    // create a scanner for each file
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line);
                    }
                    scanner.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}