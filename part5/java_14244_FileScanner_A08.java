import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_14244_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // replace with your directory path
        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (!file.getName().endsWith(".bak")) {
                        try (Scanner scanner = new Scanner(file)) {
                            while (scanner.hasNextLine()) {
                                System.out.println(scanner.nextLine());
                            }
                        } catch (FileNotFoundException e) {
                            System.out.println("File not found: " + file.getName());
                        }
                    }
                }
            } else {
                System.out.println("No files in the directory.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }
}