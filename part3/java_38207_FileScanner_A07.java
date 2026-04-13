import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_38207_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "/path/to/directory";
        File directory = new File(directoryPath);
        countFilesAndCode(directory);
    }

    public static void countFilesAndCode(File directory) throws FileNotFoundException {
        int lines = 0;
        int words = 0;
        int characters = 0;
        for (File file : directory.listFiles()) {
            if (file.isFile()) {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    lines++;
                    words += line.split("\\s+").length;
                    characters += line.length();
                }
                scanner.close();
            } else if (file.isDirectory()) {
                countFilesAndCode(file);
            }
        }
        System.out.println("Files: " + (directory.listFiles().length));
        System.out.println("Lines: " + lines);
        System.out.println("Words: " + words);
        System.out.println("Characters: " + characters);
    }
}