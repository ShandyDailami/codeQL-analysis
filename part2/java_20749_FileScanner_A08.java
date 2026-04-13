import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_20749_FileScanner_A08 {

    private static long totalSize = 0;

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("path_to_your_directory");
        scan(file);
        System.out.println("Total size of all files: " + totalSize + " bytes");
    }

    private static void scan(File file) throws FileNotFoundException {
        if (file.isDirectory()) {
            for (File innerFile : file.listFiles()) {
                scan(innerFile);
            }
        } else if (file.getName().endsWith(".txt")) {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                scanner.nextLine();
            }
            scanner.close();
            totalSize += file.length();
        }
    }
}