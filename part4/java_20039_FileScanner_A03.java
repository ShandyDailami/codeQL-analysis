import java.io.File;
import java.util.Scanner;

public class java_20039_FileScanner_A03 {

    public static void main(String[] args) {
        File folder = new File("path_to_folder"); // specify your folder here
        countLinesInFolder(folder);
    }

    private static void countLinesInFolder(File folder) {
        int lineCount = 0;

        if (folder.isDirectory()) {
            for (File file : folder.listFiles()) {
                if (file.isFile()) {
                    countLinesInFile(file, lineCount);
                } else if (file.isDirectory()) {
                    countLinesInFolder(file);
                }
            }
        } else if (folder.isFile()) {
            countLinesInFile(folder, lineCount);
        }

        System.out.println("Total lines: " + lineCount);
    }

    private static void countLinesInFile(File file, int lineCount) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                lineCount++;
                scanner.nextLine();
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + file.getPath());
        }
    }
}