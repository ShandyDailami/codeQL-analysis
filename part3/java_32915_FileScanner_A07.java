import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_32915_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // replace with your directory path
        File directory = new File(directoryPath);

        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());

                    int lineCount = 0;
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNextLine()) {
                            scanner.nextLine();
                            lineCount++;
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("Error reading file: " + file.getName());
                    }

                    System.out.println("Line count: " + lineCount);
                }
            }
        }
    }
}