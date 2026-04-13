import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_30024_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        scanFilesInDirectory(directoryPath);
    }

    private static void scanFilesInDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        File[] directoryFiles = directory.listFiles((dir, name) -> name.endsWith("txt"));

        if (directoryFiles != null) {
            for (File file : directoryFiles) {
                if (file.canRead()) {
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            if (line.contains("sensitive")) {
                                System.out.println("File: " + file.getName() + ", Content: " + line);
                            }
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}