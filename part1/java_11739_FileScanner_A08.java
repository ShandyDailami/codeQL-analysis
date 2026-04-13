import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_11739_FileScanner_A08 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(".");
        printFileInfo(file);

        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isFile() && f.getName().endsWith(".txt")) {
                    printFileInfo(f);
                }
            }
        }
    }

    private static void printFileInfo(File file) throws FileNotFoundException {
        long lines = 0;
        long chars = 0;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lines++;
                chars += line.length();
            }
        }

        System.out.println("File: " + file.getAbsolutePath());
        System.out.println("Lines: " + lines);
        System.out.println("Chars: " + chars);
        System.out.println();
    }
}