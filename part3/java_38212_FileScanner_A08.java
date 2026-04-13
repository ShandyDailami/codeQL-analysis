import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_38212_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "path/to/directory";  // replace with your directory path
        File directory = new File(directoryPath);

        File[] hiddenFiles = directory.listFiles((dir, name) -> name.startsWith(".svn"));

        if (hiddenFiles != null) {
            for (File file : hiddenFiles) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println("File: " + file.getPath() + ", Line: " + line);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}