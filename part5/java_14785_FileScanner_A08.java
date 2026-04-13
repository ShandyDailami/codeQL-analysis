import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_14785_FileScanner_A08 {
    public static void main(String[] args) {
        File directory = new File(".");
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.length() < 100) {
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            System.out.println(line);
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    System.out.println("File is too large to read.");
                    break;
                }
            }
        }
    }
}