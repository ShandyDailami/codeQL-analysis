import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_08667_FileScanner_A07 {
    public static void main(String[] args) {
        File directory = new File(".");
        String extension = "txt";

        File[] files = directory.listFiles((dir, name) -> name.endsWith(extension));

        if (files != null) {
            for (File file : files) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}