import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_02915_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // replace with your directory path
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try (Scanner scanner = new Scanner(file)) {
                        System.out.println("File contents for: " + file.getName());
                        while (scanner.hasNextLine()) {
                            System.out.println(scanner.nextLine());
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found: " + file.getName());
                    }
                }
            }
        } else {
            System.out.println("Directory is empty");
        }
    }
}