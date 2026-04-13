import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_21133_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        String fileExtension = ".txt"; // replace with your file extension
        countLinesInDirectory(directoryPath, fileExtension);
    }

    public static void countLinesInDirectory(String directoryPath, String fileExtension) {
        File directory = new File(directoryPath);
        File[] allFiles = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

        if (allFiles == null) {
            System.out.println("No files found!");
            return;
        }

        for (File file : allFiles) {
            int lineCount = 0;
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    scanner.nextLine();
                    lineCount++;
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + file.getPath());
                return;
            }

            System.out.println("Number of lines in " + file.getName() + ": " + lineCount);

            try (PrintWriter writer = new PrintWriter(new File(file.getParent() + "/count.txt"))) {
                writer.println("Number of lines in " + file.getName() + ": " + lineCount);
            } catch (FileNotFoundException e) {
                System.out.println("Error writing to count.txt: " + file.getPath());
                return;
            }
        }
    }
}