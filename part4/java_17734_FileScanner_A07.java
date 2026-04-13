import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_17734_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "C:\\path\\to\\directory"; // replace with your directory path
        File dir = new File(directoryPath);
        countFiles(dir);
    }

    private static void countFiles(File dir) throws FileNotFoundException {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    countFile(file);
                } else if (file.isDirectory()) {
                    countFiles(file);
                }
            }
        }
    }

    private static void countFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        int lines = 0;
        int words = 0;
        int chars = 0;

        while (scanner.hasNextLine()) {
            lines++;
            String line = scanner.nextLine();
            words += line.split("\\s+").length;
            chars += line.length();
        }

        scanner.close();

        System.out.println("File: " + file.getPath());
        System.out.println("Lines: " + lines);
        System.out.println("Words: " + words);
        System.out.println("Chars: " + chars);
        System.out.println("------");
    }
}