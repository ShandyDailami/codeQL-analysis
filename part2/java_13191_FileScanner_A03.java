import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.FileNotFoundException;
import java.util.Scanner;

public class java_13191_FileScanner_A03 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/your/directory"; // Replace with your directory path

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNextLine()) {
                            System.out.println(scanner.nextLine());
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found: " + file.getPath());
                    }
                }
            }
        }
    }
}