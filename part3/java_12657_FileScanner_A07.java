import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_12657_FileScanner_A07 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        String pattern = ".java"; // replace with your pattern

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.getName().endsWith(pattern)) {
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            // Here you can process the file content safely,
                            // but you must ensure that the content is not shared among multiple threads or if file content changes
                            // in the middle of being processed.
                            System.out.println(line);
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}