import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_26927_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/your/directory"; // Replace this with your directory path
        File directory = new File(directoryPath);
        
        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.canRead()) {
                        try (Scanner scanner = new Scanner(file)) {
                            while (scanner.hasNextLine()) {
                                String line = scanner.nextLine();
                                // Process the line, but don't print it here
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}