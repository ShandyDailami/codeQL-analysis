import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_03855_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        File rootDirectory = new File("."); // current directory
        listFiles(rootDirectory);
    }

    private static void listFiles(File directory) throws FileNotFoundException {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    listFiles(file); // recursion
                } else {
                    printFile(file);
                }
            }
        }
    }

    private static void printFile(File file) throws FileNotFoundException {
        System.out.println(file.getPath());
        if (file.length() > 1000) {
            System.out.println("File contains: " + file.getName());
            printContent(file);
        }
    }

    private static void printContent(File file) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        }
    }
}