import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_26469_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("path_to_directory"); // Specify your directory here
        printFileContents(file);
    }

    public static void printFileContents(File file) throws FileNotFoundException {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    printFileContents(f);
                }
            }
        } else {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        }
    }
}