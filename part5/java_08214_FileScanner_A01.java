import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_08214_FileScanner_A01 {

    public static void main(String[] args) {
        File file = new File(".");

        printDirectoryInfo(file);
    }

    private static void printDirectoryInfo(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    printDirectoryInfo(f);
                }
            }
        } else {
            printFileInfo(file);
        }
    }

    private static void printFileInfo(File file) {
        if (file.canRead()) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    System.out.println(scanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Cannot read file: " + file.getAbsolutePath());
        }
    }
}