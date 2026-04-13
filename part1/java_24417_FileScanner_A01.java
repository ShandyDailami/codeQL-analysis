import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_24417_FileScanner_A01 {

    public static void main(String[] args) {
        File directory = new File("data");
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.getName().equals("example.txt")) {
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            System.out.println(line);
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found");
                    }
                }
            }
        }
    }
}