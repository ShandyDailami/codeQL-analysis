import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_30731_FileScanner_A03 {

    public static void main(String[] args) {
        File directory = new File(".");
        countLinesInDirectory(directory);
    }

    public static void countLinesInDirectory(File directory) {
        File[] listFiles = directory.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isFile()) {
                    countLinesInFile(file);
                } else if (file.isDirectory()) {
                    countLinesInDirectory(file);
                }
            }
        }
    }

    public static void countLinesInFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            int lineCount = 0;
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                lineCount++;
            }
            System.out.println("Number of lines in " + file.getPath() + ": " + lineCount);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}