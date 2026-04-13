import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_27891_FileScanner_A08 {
    public static void main(String[] args) {
        File directory = new File("path_to_your_directory");
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            System.out.println(line);
                       
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found: " + file.getPath());
                    }
                }
            }
        }
    }
}