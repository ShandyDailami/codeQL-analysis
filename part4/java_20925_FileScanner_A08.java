import java.io.File;
import java.util.Scanner;

public class java_20925_FileScanner_A08 {
    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        scanner.scan(".", File.separator + ".bak"); // replace the directory with your target directory
    }
}

class FileScanner {
    public void scan(String rootDir, String ignoreExt) {
        File root = new File(rootDir);
        File[] files = root.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && !file.getName().endsWith(ignoreExt)) {
                    System.out.println("Reading file: " + file.getName());
                    // read and print the content of the file
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNext()) {
                        System.out.println(scanner.nextLine());
                    }
                    scanner.close();
                } else if (file.isDirectory()) {
                    scan(file.getAbsolutePath(), ignoreExt);
                }
            }
        }
    }
}