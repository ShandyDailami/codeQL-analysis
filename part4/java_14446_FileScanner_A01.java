import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class java_14446_FileScanner_A01 {
    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        scanner.scan("C:\\path\\to\\your\\directory", true);
    }
}

class FileScanner {
    void scan(String path, boolean recursive) {
        File file = new File(path);

        if (file.exists()) {
            if (file.isDirectory()) {
                File[] subFiles = file.listFiles();

                if (subFiles != null) {
                    for (File f : subFiles) {
                        scan(f.getAbsolutePath(), recursive);
                    }
                }
            } else {
                if (!file.canRead()) {
                    System.out.println("The file " + file.getAbsolutePath() + " is not readable.");
                } else {
                    try (Scanner scanner = new Scanner(new FileReader(file))) {
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            System.out.println(line);
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            System.out.println("The directory " + path + " does not exist.");
        }
    }
}