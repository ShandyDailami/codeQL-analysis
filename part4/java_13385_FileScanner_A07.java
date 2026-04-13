import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_13385_FileScanner_A07 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(".");

        scanDirectory(file, 0);
    }

    private static void scanDirectory(File directory, int level) throws FileNotFoundException {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                printIndentation(level);

                if (file.isDirectory()) {
                    if (file.getName().equals("target")) {
                        printIndentation(level + 1);
                        System.out.println("Skipping target directory");
                        continue;
                    }
                    scanDirectory(file, level + 1);
                } else if (file.isFile()) {
                    printFileInfo(file);
                }
            }
        }
    }

    private static void printIndentation(int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }
    }

    private static void printFileInfo(File file) throws FileNotFoundException {
        System.out.println("File: " + file.getName());

        if (file.getName().endsWith(".java")) {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                System.out.println("Line: " + scanner.nextLine());
            }
            scanner.close();
        }
    }
}