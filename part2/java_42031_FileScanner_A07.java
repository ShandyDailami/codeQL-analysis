import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_42031_FileScanner_A07 {
    public static void main(String[] args) {
        File directory = new File(".");
        String extension = ".java";
        File[] javaFiles = directory.listFiles((dir, name) -> name.endsWith(extension));

        if (javaFiles != null) {
            for (File file : javaFiles) {
                try (Scanner scanner = new Scanner(file)) {
                    System.out.println("Content of file " + file.getName());
                    while (scanner.hasNextLine()) {
                        System.out.println(scanner.nextLine());
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("File not found: " + file.getName());
                }
            }
        }
    }
}