import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_40605_FileScanner_A08 {

    public static void main(String[] args) {
        String currentDir = System.getProperty("user.dir");
        File directory = new File(currentDir);

        File[] files = directory.listFiles((dir, name) -> name.endsWith(".txt"));

        if (files != null) {
            for (File file : files) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        // This line is just to keep the program from crashing due to the next line.
                        // In a real program, you would want to add error handling here.
                        System.out.println(line);
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("File not found: " + file.getAbsolutePath());
                }
            }
        }
    }
}