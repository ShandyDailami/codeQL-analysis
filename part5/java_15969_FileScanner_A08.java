import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_15969_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        File rootDir = new File("."); // Current directory
        findTXTFiles(rootDir);
    }

    private static void findTXTFiles(File dir) throws FileNotFoundException {
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    findTXTFiles(file);
                } else if (file.getName().endsWith(".txt")) {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line);
                    }
                    scanner.close();
                }
            }
        }
    }
}