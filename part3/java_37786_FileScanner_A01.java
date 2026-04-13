import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_37786_FileScanner_A01 {
    public static void main(String[] args) {
        File file = new File("path/to/your/directory");
        scanDirectory(file);
    }

    public static void scanDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().equals("yourFileName.ext")) {
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNextLine()) {
                            System.out.println(scanner.nextLine());
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                } else if (file.isDirectory()) {
                    scanDirectory(file);
                }
            }
        }
    }
}