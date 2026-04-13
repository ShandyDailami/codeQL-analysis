import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_01915_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File("test.txt");
        if (file.exists()) {
            if (file.isFile()) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNext()) {
                        String line = scanner.nextLine();
                        System.out.println(line);
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("File not found!");
                }
            } else {
                System.out.println("The path is not a file!");
            }
        } else {
            System.out.println("The file does not exist!");
        }
    }
}