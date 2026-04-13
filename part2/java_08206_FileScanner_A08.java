import java.io.File;
import java.util.Scanner;

public class java_08206_FileScanner_A08 {
    public static void main(String[] args) {
        File directory = new File("."); // get the current directory

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        printFileContents(file);
                    }
                }
            }
        }
    }

    private static void printFileContents(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + file.getName());
        }
    }
}