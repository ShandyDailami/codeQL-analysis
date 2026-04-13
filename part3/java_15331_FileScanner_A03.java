import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_15331_FileScanner_A03 {
    public static void main(String[] args) {
        File root = new File(".");
        scanDirectory(root);
    }

    private static void scanDirectory(File directory) {
        File[] list = directory.listFiles();
        if (list == null) return;

        for (File file : list) {
            if (file.getName().equals("secret.txt")) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println("Found line in secret.txt: " + line);
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